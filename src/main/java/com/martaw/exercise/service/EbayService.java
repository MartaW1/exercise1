package com.martaw.exercise.service;

import com.martaw.exercise.model.EbayQueryResponse;
import com.martaw.exercise.model.EbayToken;
import com.martaw.exercise.repository.EbayRequestRepository;
import com.martaw.exercise.repository.EbayResponseRepository;
import com.martaw.exercise.repository.EbayTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public EbayQueryResponse searchQuery(String query) {
        EbayToken token = ebayTokenRepository.getToken();
        EbayQueryResponse response = ebayClientService.searchQuery(query, token.getAccess_token());
        ebayRequestRepository.save(query);
        ebayResponseRepository.save(response);
        return response;
    }

    public EbayToken getToken() {
        EbayToken ebayToken = ebayClientService.getToken();
        ebayTokenRepository.save(ebayToken);
        return ebayToken;
    }
}