package com.martaw.exercise.service;

import com.martaw.exercise.model.AllegroQueryResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class AllegroClientService {

    public List<AllegroQueryResponse> search (String query){
        //TODO podłączyć do allegro, nowe metody
        AllegroQueryResponse query1 = new AllegroQueryResponse(query,new Date());
        List<AllegroQueryResponse> responseList = new ArrayList<>();
        responseList.add(query1);
        return responseList;
    }
}
