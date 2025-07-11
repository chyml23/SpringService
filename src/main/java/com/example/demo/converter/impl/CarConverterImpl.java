package com.example.demo.converter.impl;

import com.example.demo.converter.CarConverter;
import com.example.demo.model.ClientCarModel;
import com.example.demo.model.ServerCarModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarConverterImpl implements CarConverter {

    @Override
    public ClientCarModel convert(List<ServerCarModel> cars) {
        ServerCarModel mostExpensiveCarModel = cars.getFirst();
        for (ServerCarModel car : cars) {
            if (car.getPrice().getAmount() > mostExpensiveCarModel.getPrice().getAmount()) {
                mostExpensiveCarModel = car;
            }
        }
        ClientCarModel clientCarModel = new ClientCarModel();
        clientCarModel.setName(mostExpensiveCarModel.getMake() + mostExpensiveCarModel.getModel());
        clientCarModel.setProductionYear(mostExpensiveCarModel.getYear());
        clientCarModel.setPrice(mostExpensiveCarModel.getPrice().getAmount() + mostExpensiveCarModel.getPrice().getUnit());

        return clientCarModel;
    }
}
