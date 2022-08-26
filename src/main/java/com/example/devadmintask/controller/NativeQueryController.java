package com.example.devadmintask.controller;

import com.example.devadmintask.service.NativeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class NativeQueryController {

    @Autowired
    private NativeQueryService nqs;

    @PostMapping(value="/native-query", consumes = MediaType.TEXT_PLAIN_VALUE)
    public String home(@RequestBody String query) {
        return nqs.query(query);
    }
}
