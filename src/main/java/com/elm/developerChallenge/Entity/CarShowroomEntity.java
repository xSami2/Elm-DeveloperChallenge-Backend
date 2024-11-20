package com.elm.developerChallenge.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.Where;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Table(name = "car_showroom")
@Where(clause = "active = true")
@Entity
public class CarShowroomEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Column(name = "commercial_registration_number", nullable = false, unique = true, length = 10)
    private String commercialRegistrationNumber;

    @Column(name = "manager_name" , length = 100)
    private String managerName;

    @Column(name = "contact_number" , nullable = false, length = 15)
    private String contactNumber;

    @Column(length = 255)
    private String address;

    @OneToMany(mappedBy = "carShowroom" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CarEntity> carEntityList = new ArrayList<>();

    private Instant created_at;

    private Instant updated_at;

    private boolean active = true;


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
