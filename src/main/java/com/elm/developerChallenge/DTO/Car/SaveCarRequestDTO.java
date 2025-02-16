package com.elm.developerChallenge.DTO.Car;

import com.elm.developerChallenge.DTO.ShowroomDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SaveCarRequestDTO {




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

    @NotNull
    private String carShowroomId;

}
