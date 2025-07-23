package com.example.demo.converter.impl;

import com.example.demo.converter.ResponseConverter;
import com.example.demo.model.mockoon.CreateUserResponse;
import com.example.demo.model.postman.ResponseConverted;
import org.springframework.stereotype.Component;

@Component
public class ResponseConverterImpl implements ResponseConverter {


    @Override
    public ResponseConverted convert(CreateUserResponse createUserResponse) {
        ResponseConverted responseConverted = new ResponseConverted();
        responseConverted.setId(createUserResponse.getExternalId());
        responseConverted.setCurrentCustomerStatus(createUserResponse.getStatus());
        return responseConverted;
    }
}
