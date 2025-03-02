package com.elm.developerChallenge.DTO.Respones.Car;


import lombok.Data;


@Data
public class GetCarResponsesDTO {



    private String id;

    private String vehicleIdentificationNumber;
    private String maker;


    private String model;



    private String modelYear;

    private Double price;

    private String carShowroomId;



}
