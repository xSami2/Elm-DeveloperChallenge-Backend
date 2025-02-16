package com.elm.developerChallenge.DTO.Car;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveCarResponsesDTO {



    private String id;

    private String vehicleIdentificationNumber;

    private String maker;

    private String model;


    private String modelYear;

    private Double price;

    private String carShowroomId;

}
