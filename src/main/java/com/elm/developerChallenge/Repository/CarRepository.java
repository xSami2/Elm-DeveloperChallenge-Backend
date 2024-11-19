package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarEntity , String> {


    @Query("SELECT c FROM CarEntity c JOIN FETCH c.carShowroom")
    List<CarEntity> findAllWithShowroom();
}
