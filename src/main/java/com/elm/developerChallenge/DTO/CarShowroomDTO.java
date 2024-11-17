package com.elm.developerChallenge.DTO;


import com.elm.developerChallenge.Entity.CarEntity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class CarShowroomDTO {


    private UUID uuid;



    @NotEmpty(message = "Name cannot be empty or null.")
    @Size(max = 100, message = "Name must be at most 100 characters long.")
    private String name;

    @NotEmpty(message = "Commercial Registration Number cannot be empty or null.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Commercial Registration Number must be exactly 10 digits.")
    private String commercialRegistrationNumber;

    @Size(max = 100, message = "Manager Name must be at most 100 characters long.")
    private String managerName;

    @NotEmpty(message = "Contact Number is required and cannot be empty.")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "Commercial registration number must be between 10 and 15 digits")
    private String contactNumber;

    @Size(max = 255, message = "Address must be at most 255 characters long.")
    private String address;

    private List<CarEntity> carList = new ArrayList<>();


    public CarShowroomDTO(String name, String commercialRegistrationNumber, String contactNumber) {
        this.name = name;
        this.commercialRegistrationNumber = commercialRegistrationNumber;
        this.contactNumber = contactNumber;
    }


}
