package com.example.demo.webclient;

import com.example.demo.model.Car;
import com.example.demo.model.ServerCarModel;

import java.util.List;


public interface TestWebClient {
    Car getCar();
    List<ServerCarModel> getAvailableCars();

}
