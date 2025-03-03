package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.DTO.Respones.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowroomRepository extends JpaRepository<ShowroomEntity, String> {



  @Query("select name from ShowroomEntity")
  List<String> findAllCarShowroomNames();

  Optional<ShowroomEntity> findShowroomEntityByCommercialRegistrationNumber(String id);
  Optional<ShowroomEntity> findShowroomEntityById(String id);

}
