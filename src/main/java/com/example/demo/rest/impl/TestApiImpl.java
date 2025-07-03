package com.example.demo.rest.impl;

import com.example.demo.model.Body;
import com.example.demo.rest.TestApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestApiImpl implements TestApi {

    @Override
    public String getTest() {
        return "Yo WORLD";
    }

    @Override
    public int getSum() {
        return 99 + 99;
    }

    @Override
    public int getSumWithParam(int number) {
        return number + 99;
    }

    @Override
    public String processBody(List<Body> bodyList) {
        return "I'm " + bodyList.get(0).getName() + " from " +  bodyList.get(0).getCity() + " , age - " + bodyList.get(0).getAge()
                + " and my friend " + bodyList.get(1).getName() + " from " +  bodyList.get(1).getCity() + " , age - " + bodyList.get(1).getAge();
    }
}
