package com.example.demo.converter.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.model.postman.User;
import com.example.demo.model.mockoon.UserConverted;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserConverted convert(User user) {
        UserConverted userConverted = new UserConverted();
        userConverted.setUuid(user.getId());
        userConverted.setName(user.getName());
        userConverted.setBirthYear(user.getAge());
        userConverted.setHomeAdress(user.getAdress());
        userConverted.setEducationOrganization(user.getEducation().getUniversity());
        userConverted.setGraduationDate(user.getEducation().getGraduationDate());

        return userConverted;

    }
}
