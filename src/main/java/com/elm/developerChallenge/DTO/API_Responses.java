package com.elm.developerChallenge.DTO;


import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.Data;

@Hidden
@AllArgsConstructor
@Data
public class API_Responses<T> {

    private Integer statusCode;
    private String statusMessage;
    private T data;
}
