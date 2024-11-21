package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.Entity.CarEntity;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, String> , JpaSpecificationExecutor<CarEntity> {

    @Query("SELECT c  FROM CarEntity c JOIN FETCH c.carShowroom")
    Page<CarEntity> findAllWithShowroom(Pageable pageable);

    List<CarEntity> findAllByCarShowroom_Id(String carShowroomId);






}
