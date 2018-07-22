package com.martaw.exercise.service;

import com.martaw.exercise.model.EbayQueryRequest;
import com.martaw.exercise.model.EbayToken;
import com.martaw.exercise.model.ebayRespose.EbayQueryResponse;
import com.martaw.exercise.model.exception.ServiceNotAvailableException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class EbayClientService {

    @Value("#{environment.oAuthCredentials}")
    private String oAuthCredentials;

    @Value("#{environment.ruNameCredentials}")
    private String ruNameCredentials;

    public EbayToken getToken() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("Authorization", "Basic " + oAuthCredentials);

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("redirect_uri", ruNameCredentials);
        requestBody.add("scope", "https://api.ebay.com/oauth/api_scope");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<EbayToken> ebayToken = restTemplate.exchange(
                "https://api.sandbox.ebay.com/identity/v1/oauth2/token",
                HttpMethod.POST,
                entity,
                EbayToken.class);

        return ebayToken.getBody();
    }

    public EbayQueryResponse searchQuery(EbayQueryRequest ebayQueryRequest, String token) {
        String url = buildUrl(ebayQueryRequest);

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        HttpEntity entity = new HttpEntity<>(null, headers);

        for (int i = 0; i < 4; i++) {
            ResponseEntity<EbayQueryResponse> ebayQueryResponse = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    entity,
                    EbayQueryResponse.class);
            if (ebayQueryResponse.getStatusCodeValue() == HttpStatus.OK.value()) {
                return ebayQueryResponse.getBody();
            }
        }
        throw new ServiceNotAvailableException();
    }

    public String buildUrl(EbayQueryRequest ebayQueryRequest) {
        String priceUrl = "https://api.sandbox.ebay.com/buy/browse/v1/item_summary/" +
                "search?q=" + ebayQueryRequest.getQuery() +
                "&limit=" + ebayQueryRequest.getMaxResults();

        if (ebayQueryRequest.getMaxItemPrice() != null) {
            priceUrl += "&filter=price:[0.." + ebayQueryRequest.getMaxItemPrice() + "]";
        }
        return priceUrl;
    }
}