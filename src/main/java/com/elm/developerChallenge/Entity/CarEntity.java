package com.elm.developerChallenge.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.UUID;

@Setter
@Getter
@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "vehicle_identification_number")
    private String vehicleIdentificationNumber;

    private String maker;

    private String model;

    @Column(name = "model_year")
    private String modelYear;

    private Double price;

    @ManyToOne()
    @JoinColumn(name = "car_showroom_id")
    private CarShowroomEntity carShowroom;

    private Instant created_at;

    private Instant updated_at;

    private boolean active;


    @PrePersist
    protected void onCreate() {
        this.created_at = Instant.now();
        this.active = true;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = Instant.now();
    }

}
