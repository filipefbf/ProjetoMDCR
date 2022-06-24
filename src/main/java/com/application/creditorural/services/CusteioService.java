package com.application.creditorural.services;

import com.application.creditorural.DTO.DTORoot;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CusteioService {

//    @Autowired
//    private DTORoot;

    public DTORoot jsonToJava(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, DTORoot.class);

//        ObjectMapper om = new ObjectMapper();
//        DTORoot root = om.readValue(data, DTORoot.class);

    }
}
