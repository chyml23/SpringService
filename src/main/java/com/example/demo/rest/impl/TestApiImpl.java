package com.example.demo.rest.impl;

import com.example.demo.converter.CarConverter;
import com.example.demo.model.Car;
import com.example.demo.model.ClientCarModel;
import com.example.demo.model.Person;
import com.example.demo.model.ServerCarModel;
import com.example.demo.rest.TestApi;
import com.example.demo.webclient.TestWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestApiImpl implements TestApi {
    private final TestWebClient testWebClient;
    private final CarConverter carConverter;


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
    public List<Person> processBody(List<Person> personList, int number) {
        List<Person> matchedPersons = new ArrayList<>();
        for (Person person : personList) {
            if(person.getEducation().getUniversityEndYear() > number){
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

    @Override
    public Car getCar(){
        return testWebClient.getCar();
    }

    @Override
    public ClientCarModel getMostExpensiveCar() {
        List<ServerCarModel> availableCars = testWebClient.getAvailableCars();

        return carConverter.convert(availableCars);
    }





}
