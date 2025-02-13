package com.elm.developerChallenge.Repository;

import com.elm.developerChallenge.DTO.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.ShowroomDTO;
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

  @Query(
      "SELECT new com.elm.developerChallenge.DTO.Showroom.GetAllShowroomResponsesDTO(cs.id, cs.name, cs.commercialRegistrationNumber, cs.contactNumber , cs.managerName , cs.address)" +
      "FROM ShowroomEntity cs " +
      "WHERE cs.active = true")
  Page<GetAllShowroomResponsesDTO> findAllShowroom(Pageable pageable);

  @Query("select name from ShowroomEntity ")
  List<String> findAllCarShowroomNames();

  Optional<ShowroomEntity> findShowroomEntityByCommercialRegistrationNumber(String id);
  Optional<ShowroomEntity> findShowroomEntityById(String id);

}
