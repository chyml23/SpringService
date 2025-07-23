package com.example.demo.webclient;

import com.example.demo.model.Car;
import com.example.demo.model.mockoon.BusinessUserConverted;
import com.example.demo.model.mockoon.CreateUserResponse;
import com.example.demo.model.ServerCarModel;
import com.example.demo.model.mockoon.UserConverted;

import java.util.List;


public interface TestWebClient {
    Car getCar();
    List<ServerCarModel> getAvailableCars();
    CreateUserResponse createUser(UserConverted user);
    CreateUserResponse createBusinessUser(BusinessUserConverted businessUser);


}
