package com.martaw.exercise.controller;

import com.martaw.exercise.model.AllegroQueryResponse;
import com.martaw.exercise.service.AllegroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/allegro")
public class AllegroController {
    @Autowired
    AllegroService allegroService;
    @GetMapping(path = "/search/{query}")
    public List<AllegroQueryResponse> searchQuery(@PathVariable String query) {
        return allegroService.search(query);
    }
}
