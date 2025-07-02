package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface TestApi {
    @RequestMapping(value = {"/api/test"},
            method = RequestMethod.GET)
    String getTest();

    @RequestMapping(value = {"/api/sum"},
            method = RequestMethod.GET)
    int getSum();
}
