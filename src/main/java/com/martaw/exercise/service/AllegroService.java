package com.martaw.exercise.service;

import com.martaw.exercise.model.AllegroQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllegroService {
    @Autowired
    AllegroClientService allegroClientService;
    public List<AllegroQueryResponse> search (String query){
        return allegroClientService.search(query);
    }
}
