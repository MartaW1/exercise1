package com.martaw.exercise.service;

import com.martaw.exercise.model.EbayQueryRequest;
import com.martaw.exercise.model.EbayToken;
import com.martaw.exercise.model.ebayRespose.EbayQueryResponse;
import com.martaw.exercise.repository.EbayRequestRepository;
import com.martaw.exercise.repository.EbayResponseRepository;
import com.martaw.exercise.repository.EbayTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EbayService {
    @Autowired
    EbayClientService ebayClientService;
    @Autowired
    EbayRequestRepository ebayRequestRepository;
    @Autowired
    EbayResponseRepository ebayResponseRepository;
    @Autowired
    EbayTokenRepository ebayTokenRepository;

    private static final Integer DEFAULT_MAX_RESULTS = 50;
    private static final Integer DEFAULT_RESULTS_OFFSET = 0;
    private static final Integer DEFAULT_MAX_ITEM_PRICE = null;

    public EbayQueryResponse searchQuery(EbayQueryRequest ebayQueryRequest) {
        ebayQueryRequest = replaceNullWithDefault(ebayQueryRequest);
        EbayToken token = getToken();
        EbayQueryResponse response = ebayClientService.searchQuery(ebayQueryRequest, token.getAccess_token());
        ebayRequestRepository.save(ebayQueryRequest);
        ebayResponseRepository.save(response);
        return response;
    }

    public EbayQueryRequest replaceNullWithDefault(EbayQueryRequest ebayQueryRequest) {
        if (ebayQueryRequest.getMaxResults() == null) {
            ebayQueryRequest.setMaxResults(DEFAULT_MAX_RESULTS);
        }
        if (ebayQueryRequest.getResultOffset() == null) {
            ebayQueryRequest.setResultOffset(DEFAULT_RESULTS_OFFSET);
        }
        return ebayQueryRequest;
    }

    public EbayQueryResponse searchQuery(String query) {
        EbayQueryRequest ebayQueryRequest =
                new EbayQueryRequest(null, query, DEFAULT_MAX_RESULTS, DEFAULT_RESULTS_OFFSET, DEFAULT_MAX_ITEM_PRICE);
        return searchQuery(ebayQueryRequest);
    }

    public EbayToken getToken() {
        List<EbayToken> tokens = ebayTokenRepository.findAll();
        EbayToken ebayToken;
        if (tokens.isEmpty()) {
            ebayToken = ebayClientService.getToken();
            ebayTokenRepository.save(ebayToken);
        } else {
            ebayToken = tokens.get(tokens.size() - 1);
        }
        return ebayToken;
    }
}