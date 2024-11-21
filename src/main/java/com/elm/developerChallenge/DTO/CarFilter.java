package com.elm.developerChallenge.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CarFilter {
    private String maker;
    private String model;
    private String modelYear;
    private Double price;
    private String carShowroomId;



}
