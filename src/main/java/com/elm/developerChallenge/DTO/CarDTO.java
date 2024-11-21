package com.elm.developerChallenge.DTO;


import com.elm.developerChallenge.Entity.CarShowroomEntity;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class CarDTO {



    private String id;

    @NotEmpty(message = "Vin cannot be empty or null.")
    private String vehicleIdentificationNumber;


    @NotEmpty(message = "Maker cannot be empty or null.")
    @Size(max = 25, message = "Maker must be at most 25 characters long.")
    private String maker;

    @NotEmpty(message = "Model cannot be empty or null.")
    @Size(max = 25, message = "Model must be at most 25 characters long.")
    private String model;


    @NotEmpty(message = "Model cannot be empty or null.")
    @Pattern(regexp = "^[0-9]{1,4}$", message = "Price must be exactly 10 digits.")
    private String modelYear;

    @NotNull(message = "Price cannot be null.")
    private Double price;


    private CarShowroomDTO carShowroom;



}
