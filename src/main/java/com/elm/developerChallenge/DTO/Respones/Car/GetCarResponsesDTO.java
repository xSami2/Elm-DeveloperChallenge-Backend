package com.elm.developerChallenge.DTO.Respones.Car;


import com.elm.developerChallenge.Entity.ShowroomEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
public class GetCarResponsesDTO {


    private String id;
    private String vehicleIdentificationNumber;
    private String maker;
    private String model;
    private String modelYear;
    private Double price;
    private ShowroomBasicInfo showroom;
    private Instant created_at;
    private Instant updated_at;

}
