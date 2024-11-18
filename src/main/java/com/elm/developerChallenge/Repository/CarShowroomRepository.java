package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import org.springdoc.core.converters.models.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface CarShowroomRepository extends JpaRepository<CarShowroomEntity , String> {

    @Query("SELECT new com.elm.developerChallenge.DTO.CarShowroomDTO(cs.id, cs.name, cs.commercialRegistrationNumber, cs.contactNumber) FROM CarShowroomEntity cs WHERE cs.active = true")
    List<CarShowroomDTO> findAllCarShowrooms();

    @Query("SELECT new com.elm.developerChallenge.DTO.CarShowroomDTO(cs.id, cs.name, cs.commercialRegistrationNumber, cs.contactNumber) " +
            "FROM CarShowroomEntity cs WHERE cs.active = true")
    List<CarShowroomDTO> findAllCarShowroomsSorted(Sort sort);

    Optional<CarShowroomEntity> findCarShowroomEntityById(String id);


}
