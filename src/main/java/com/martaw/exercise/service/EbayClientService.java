package com.martaw.exercise.service;

import com.martaw.exercise.model.EbayQueryResponse;
import com.martaw.exercise.model.EbayToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

        //Naglowki
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("Authorization", "Basic " + oAuthCredentials);

        //Body
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "client_credentials");
        requestBody.add("redirect_uri", ruNameCredentials);
        requestBody.add("scope", "https://api.ebay.com/oauth/api_scope");

        //Koperta http
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<EbayToken> ebayToken = restTemplate.exchange(
                "https://api.sandbox.ebay.com/identity/v1/oauth2/token",
                HttpMethod.POST,
                entity,
                EbayToken.class);        //exchange wymaga klasy. Zwrotka z ebaya zostanie spakowana w ta klase.

        return ebayToken.getBody();
    }

    public EbayQueryResponse searchQuery(String query, String token) {
        String url = "https://api.sandbox.ebay.com/buy/browse/v1/item_summary/search?q=" + query;

        RestTemplate restTemplate = new RestTemplate();
        //Naglowki
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);

        //Koperta http
        HttpEntity entity = new HttpEntity<>(null, headers);

        ResponseEntity<EbayQueryResponse> ebayQueryResponse = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                EbayQueryResponse.class);

        return ebayQueryResponse.getBody();
    }
}