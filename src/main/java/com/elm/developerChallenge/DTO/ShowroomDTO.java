package com.elm.developerChallenge.DTO;


import com.elm.developerChallenge.DTO.Car.GetCarResponsesDTO;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShowroomDTO {


    private String id;



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

    private List<GetCarResponsesDTO> getCarResponsesDTOList = new ArrayList<>();


    public ShowroomDTO(String id , String name, String commercialRegistrationNumber, String contactNumber) {
        this.id = id;
        this.name = name;
        this.commercialRegistrationNumber = commercialRegistrationNumber;
        this.contactNumber = contactNumber;
    }


}
