package com.example.demo.model.postman;

import com.example.demo.model.Education;
import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private int age;
    private String adress;
    private Education education;
    private WorkInfo workInfo;
}
