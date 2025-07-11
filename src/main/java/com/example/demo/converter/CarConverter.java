package com.example.demo.converter;


import com.example.demo.model.ClientCarModel;
import com.example.demo.model.ServerCarModel;

import java.util.List;

public interface CarConverter {
    ClientCarModel convert(List<ServerCarModel> cars);

}
