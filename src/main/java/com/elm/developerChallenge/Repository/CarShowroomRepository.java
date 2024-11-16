package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.Entity.CarShowroomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CarShowroomRepository extends JpaRepository<CarShowroomEntity , UUID> {
}
