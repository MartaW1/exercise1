package com.martaw.exercise.controller;

import com.martaw.exercise.model.EbayQueryRequest;
import com.martaw.exercise.model.EbayToken;
import com.martaw.exercise.model.ebayRespose.EbayQueryResponse;
import com.martaw.exercise.model.exception.ServiceNotAvailableException;
import com.martaw.exercise.service.EbayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ebay")
public class EbayController {
    @Autowired
    EbayService ebayService;

    @GetMapping(path = "/search/{query}")
    public EbayQueryResponse searchQuery(@PathVariable String query) {
        return ebayService.searchQuery(query);
    }

    @PostMapping(path = "/search")
    public EbayQueryResponse searchQuery(@RequestBody @Validated EbayQueryRequest ebayQueryRequest) {
        return ebayService.searchQuery(ebayQueryRequest);
    }

    @GetMapping(path = "/token")
    public EbayToken getToken() {
        return ebayService.getToken();
    }
}