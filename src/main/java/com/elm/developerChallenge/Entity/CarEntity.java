package com.elm.developerChallenge.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@SQLRestriction("active = TRUE ")
@SQLDelete(sql = "UPDATE car SET active = TRUE WHERE id=?")
@Table(name = "car")
@Entity()
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
    @JoinColumn(name = "showroom_id")
    private ShowroomEntity showroom;

    @CreationTimestamp
    private Instant created_at;

    @UpdateTimestamp
    private Instant updated_at;

    private boolean active;




}
