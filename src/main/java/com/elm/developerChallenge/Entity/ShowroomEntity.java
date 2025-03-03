package com.elm.developerChallenge.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Table(name = "showroom")
@SQLRestriction("active <> TRUE  ")
@SQLDelete(sql = "UPDATE showroom SET active = TRUE WHERE id=?")
@Entity
public class ShowroomEntity {



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

    @OneToMany(mappedBy = "showroom" , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CarEntity> carEntityList = new ArrayList<>();

    @CreationTimestamp
    private Instant created_at;

    @UpdateTimestamp
    private Instant updated_at;

    private boolean active ;


}
