package com.martaw.exercise.controller;

import com.martaw.exercise.model.EbayQueryResponse;
import com.martaw.exercise.model.EbayToken;
import com.martaw.exercise.service.EbayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ebay")
public class EbayController {
    @Autowired
    EbayService ebayService;

    @GetMapping(path = "/search/{query}")
    public EbayQueryResponse searchQuery(@PathVariable String query) {
        return ebayService.searchQuery(query);
    }

    @GetMapping(path = "/token")
    public EbayToken getToken() {
        return ebayService.getToken();
    }
}