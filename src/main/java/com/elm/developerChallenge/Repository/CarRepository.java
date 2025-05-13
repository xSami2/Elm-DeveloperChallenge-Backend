package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.DTO.Respones.Car.GetAllCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> , JpaSpecificationExecutor<CarEntity> {


    @Query(" SELECT carEntity " +
            "FROM CarEntity carEntity " +
            "JOIN FETCH carEntity.showroom")
    Page<GetAllCarResponsesDTO> findAllWithShowroom(Pageable pageable);

    Page<GetAllCarResponsesDTO> findAllByShowroom_Id(String ShowroomId , Pageable page);







}
