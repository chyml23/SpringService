package com.example.demo.converter;

import com.example.demo.model.mockoon.BusinessUserConverted;
import com.example.demo.model.postman.User;

public interface BusinessUserConverter {
    BusinessUserConverted convert(User user);
}
