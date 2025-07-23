package com.example.demo.webclient.impl;

import com.example.demo.model.Car;
import com.example.demo.model.mockoon.BusinessUserConverted;
import com.example.demo.model.mockoon.CreateUserResponse;
import com.example.demo.model.ServerCarModel;
import com.example.demo.model.mockoon.UserConverted;
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

    public CreateUserResponse createUser(UserConverted user) {
        Mono<CreateUserResponse> response = webClient.post()
                .uri("http://localhost:3000/api/createUser")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        return response.block();

    }

    public CreateUserResponse createBusinessUser(BusinessUserConverted user) {
        Mono<CreateUserResponse> response = webClient.post()
                .uri("http://localhost:3000/api/createBusinessUser")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        return response.block();
    }
}
