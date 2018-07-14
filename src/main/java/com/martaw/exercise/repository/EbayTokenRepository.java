package com.martaw.exercise.repository;


import com.martaw.exercise.model.EbayToken;
import org.springframework.stereotype.Component;

@Component
public class EbayTokenRepository {
    private EbayToken lastToken;

    public void save(EbayToken ebayToken) {
        lastToken = ebayToken;
    }

    public EbayToken getToken() {
        return lastToken;
    }
}