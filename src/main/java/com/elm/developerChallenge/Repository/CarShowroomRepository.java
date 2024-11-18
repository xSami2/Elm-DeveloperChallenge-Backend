package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface CarShowroomRepository extends JpaRepository<CarShowroomEntity , UUID> {

    @Query("SELECT new com.elm.developerChallenge.DTO.CarShowroomDTO(cs.uuid, cs.name, cs.commercialRegistrationNumber, cs.contactNumber) FROM CarShowroomEntity cs WHERE cs.active = true")
    List<CarShowroomDTO> findAllActiveTrueCarShowrooms();

    Optional<CarShowroomEntity> findCarShowroomEntityByIdAndActiveTrue(String id);


}
