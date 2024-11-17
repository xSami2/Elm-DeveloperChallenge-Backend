package com.elm.developerChallenge.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@Data
@Entity
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    private String maker;

    private String model;

    @Column(name = "model_year")
    private Integer modelYear;

    private double price;

    @ManyToOne
    @JsonIgnore
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
