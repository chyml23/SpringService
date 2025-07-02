package com.example.demo.rest.impl;

import com.example.demo.rest.TestApi;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TestApiImpl implements TestApi {

    @Override
    public String getTest() {
        return "Yo WORLD";
    }

    @Override
    public int getSum() {
        return 99+99;
    }
}
