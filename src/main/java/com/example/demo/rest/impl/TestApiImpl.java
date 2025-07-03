package com.example.demo.rest.impl;

import com.example.demo.model.Person;
import com.example.demo.rest.TestApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    public List<Person> processBody(List<Person> personList, int number) {
        List<Person> matchedPersons = new ArrayList<>();
        for (Person person : personList) {
            if(person.getEducation().getUniversityEndYear() > number){
                matchedPersons.add(person);
            }
        }
        return matchedPersons;
    }

}
