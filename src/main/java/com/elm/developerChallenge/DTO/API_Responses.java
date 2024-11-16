package com.elm.developerChallenge.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class API_Responses<T> {

    private Integer statusCode;
    private String statusMessage;
    private T data;
}
