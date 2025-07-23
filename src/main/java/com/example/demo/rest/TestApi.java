package com.example.demo.rest;

import com.example.demo.model.Car;
import com.example.demo.model.ClientCarModel;
import com.example.demo.model.Person;
import com.example.demo.model.postman.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = {"/api/processBody/{number}"},
            method = RequestMethod.POST)
    List<Person> processBody(@RequestBody List<Person> body, @PathVariable(name = "number") int number);

    @RequestMapping(value = {"/api/car"},
            method = RequestMethod.GET)
    Car getCar();

    @RequestMapping(value = {"/api/mostExpensiveCar"},
            method = RequestMethod.GET)
    ClientCarModel getMostExpensiveCar();

    @RequestMapping(value = {"/api/create"},
            method = RequestMethod.POST)
    ResponseEntity createUser(@RequestBody User user,
                              @RequestParam Map<String, String> params,
                              @RequestHeader(value = "OperationType", required = true, defaultValue = "createUser") String operationType);




}
