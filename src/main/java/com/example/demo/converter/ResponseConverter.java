package com.example.demo.converter;

import com.example.demo.model.mockoon.CreateUserResponse;
import com.example.demo.model.postman.ResponseConverted;

public interface ResponseConverter {
    ResponseConverted convert(CreateUserResponse createUserResponse);

}
