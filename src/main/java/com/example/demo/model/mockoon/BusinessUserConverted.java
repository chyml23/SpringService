package com.example.demo.model.mockoon;

import lombok.Data;

import java.util.List;

@Data
public class BusinessUserConverted {
    private String uuid;
    private String name;
    private int birthYear;
    private String homeAdress;
    private List<AdditionalInfo> additionalInfo;

}
