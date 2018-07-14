package com.martaw.exercise.repository;

import org.springframework.stereotype.Component;

@Component
public class EbayRequestRepository {
    private String lastRequest;

    public void save(String query) {
        lastRequest = query;
    }
}