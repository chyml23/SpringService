package com.example.demo.converter;

import com.example.demo.model.postman.User;
import com.example.demo.model.mockoon.UserConverted;

public interface UserConverter {
    UserConverted convert(User user);

}
