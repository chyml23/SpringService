package com.example.demo.rest;

import com.example.demo.model.Body;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface TestApi {
    @RequestMapping(value = {"/api/test"},
            method = RequestMethod.GET)
    String getTest();

    @RequestMapping(value = {"/api/sum"},
            method = RequestMethod.GET)
    int getSum();

    @RequestMapping(value = {"/api/sum/{number}"},
            method = RequestMethod.GET)
    int getSumWithParam(@PathVariable(name = "number") int number);

    @RequestMapping(value = {"/api/processBody"},
            method = RequestMethod.POST)
    String processBody(@RequestBody List<Body> body);
}
