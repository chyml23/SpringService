package com.example.demo.rest.impl;

import com.example.demo.converter.BusinessUserConverter;
import com.example.demo.converter.CarConverter;
import com.example.demo.converter.ResponseConverter;
import com.example.demo.converter.UserConverter;
import com.example.demo.model.Car;
import com.example.demo.model.ClientCarModel;
import com.example.demo.model.Person;
import com.example.demo.model.ServerCarModel;
import com.example.demo.model.mockoon.BusinessUserConverted;
import com.example.demo.model.mockoon.CreateUserResponse;
import com.example.demo.model.mockoon.UserConverted;
import com.example.demo.model.postman.ResponseConverted;
import com.example.demo.model.postman.User;
import com.example.demo.rest.TestApi;
import com.example.demo.webclient.TestWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TestApiImpl implements TestApi {
    private final TestWebClient testWebClient;
    private final CarConverter carConverter;
    private final UserConverter userConverter;
    private final ResponseConverter responseConverter;
    private final BusinessUserConverter businessUserConverter;


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
//        for (Person person : personList) {
//            if(person.getEducation().getGraduationDate() > number){
//                matchedPersons.add(person);
//            }
//        }
        return matchedPersons;
    }

    @Override
    public Car getCar() {
        return testWebClient.getCar();
    }

    @Override
    public ClientCarModel getMostExpensiveCar() {
        List<ServerCarModel> availableCars = testWebClient.getAvailableCars();

        return carConverter.convert(availableCars);
    }

    @Override
    public ResponseEntity createUser(User user, Map<String, String> params, String operationType) {
        String responseExpected = params.get("responseExpected");
        boolean responseExpectedBool = Boolean.parseBoolean(responseExpected);

        if (operationType.equals("createUser")) {
            UserConverted userConverted = userConverter.convert(user);
            CreateUserResponse response = testWebClient.createUser(userConverted);
            if(responseExpectedBool){
                ResponseConverted responseConverted = responseConverter.convert(response);
                return new ResponseEntity(responseConverted, HttpStatus.CREATED);
            }
            return new ResponseEntity("{}", HttpStatus.CREATED);

        } else if (operationType.equals("createBusinessUser")) {
            BusinessUserConverted businessUserConverted = businessUserConverter.convert(user);
            CreateUserResponse response = testWebClient.createBusinessUser(businessUserConverted);
            if(responseExpectedBool){
                ResponseConverted responseConverted = responseConverter.convert(response);
                return new ResponseEntity(responseConverted, HttpStatus.CREATED);
            }
            return new ResponseEntity("{}", HttpStatus.CREATED);

        } else {
            return new ResponseEntity("invalid OperationType header", HttpStatus.BAD_REQUEST);
        }

    }
}
