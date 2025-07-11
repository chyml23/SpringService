package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class ServerCarModel {
    private String make;
    private String model;
    private int year;
    private List<String> possibleColours;
    private Price price;

}
