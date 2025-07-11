package com.example.demo.webclient.impl;

import com.example.demo.model.Car;
import com.example.demo.model.ServerCarModel;
import com.example.demo.webclient.TestWebClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service

public class TestWebClientImpl implements TestWebClient {
    private final WebClient webClient;

    // Constructor injection
    public TestWebClientImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    public Car getCar() {
        Mono<Car> response = webClient.get()
                .uri("http://localhost:3000/api/car")
                .retrieve()
                .bodyToMono(Car.class);
        return response.block();
    }

    public List<ServerCarModel> getAvailableCars() {
        Mono<List<ServerCarModel>> response = webClient.get()
                .uri("http://localhost:3000/api/getAvailableCars")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        return response.block();
    }

}
