package com.elm.developerChallenge.DTO;


import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
public class CarDTO {


    private String uuid;

    private String maker;

    private String model;

    private Integer modelYear;

    private double price;


    private CarShowroomEntity carShowroom;

    private Instant created_at;

    private Instant updated_at;

    private boolean active;


}
