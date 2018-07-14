package com.martaw.exercise.repository;

import com.martaw.exercise.model.EbayQueryResponse;
import org.springframework.stereotype.Component;

@Component
public class EbayResponseRepository {
    private EbayQueryResponse lastEbayQueryResponse;

    public void save(EbayQueryResponse ebayQueryResponse) {
        lastEbayQueryResponse = ebayQueryResponse;
    }
}