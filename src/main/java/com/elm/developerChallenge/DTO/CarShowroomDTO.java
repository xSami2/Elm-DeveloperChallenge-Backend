package com.elm.developerChallenge.DTO;


import com.elm.developerChallenge.Entity.Car;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CarShowroomDTO {


    private UUID uuid;

    @NotNull(message = "Name is required.")
    @NotEmpty(message = "Name cannot be empty.")
    @Size(max = 100, message = "Name must be at most 100 characters long.")
    private String name;

    @NotNull(message = "Commercial Registration Number is required.")
    @NotEmpty(message = "Commercial Registration Number cannot be empty.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Commercial registration number must be between 10 and 15 digits")
    private String commercialRegistrationNumber;

    @NotNull(message = "Manager Name is required.")
    @Size(max = 100, message = "Manager Name must be at most 100 characters long.")
    private String managerName;

    @NotNull(message = "Contact Number is required.")
    @NotEmpty(message = "Contact Number cannot be empty.")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Commercial registration number must be between 10 and 15 digits")
    private String contactNumber;

    @NotNull(message = "Address is required.")
    @Size(max = 255, message = "Address must be at most 255 characters long.")
    private String address;

    private List<Car> carList = new ArrayList<>();


}
