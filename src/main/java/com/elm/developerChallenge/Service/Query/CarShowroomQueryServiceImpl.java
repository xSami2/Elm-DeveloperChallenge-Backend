package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarShowroomMapper;
import com.elm.developerChallenge.Repository.CarShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarShowroomQueryServiceImpl {

  private final CarShowroomRepository carShowroomRepository;
  private final CarShowroomMapper carShowroomMapper;

  public ResponseEntity<API_Responses<List<CarShowroomDTO>>> getAllCarShowrooms() {
    List<CarShowroomDTO> carShowroomDTOList = carShowroomRepository.findAllCarShowrooms();
    return ResponseEntity.status(HttpStatus.OK)
        .body(new API_Responses<>(200, "Get All Car Showrooms", carShowroomDTOList));
  }

  public ResponseEntity<API_Responses<CarShowroomDTO>> getCarShowroom(String uuid) {
    Optional<CarShowroomEntity> optionalCarShowroomEntity =
        carShowroomRepository.findCarShowroomEntityById(uuid);

    if (optionalCarShowroomEntity.isPresent()) {
      CarShowroomEntity carShowroomEntity = optionalCarShowroomEntity.get();
      CarShowroomDTO carShowroomDTO = carShowroomMapper.convertToCarShowroomDTO(carShowroomEntity);
      return ResponseEntity.status(HttpStatus.OK)
          .body(new API_Responses<>(200, "Get Car Showroom", carShowroomDTO));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new API_Responses<>(404, "Could not find Car Showroom with id : " + uuid, null));
  }

  public ResponseEntity<API_Responses<List<CarShowroomDTO>>> getAllActiveCarShowroomsSorted(String sortBy , String sortDirection) {
    Sort.Direction direction = Sort.Direction.fromString(sortDirection);
    Sort sort = Sort.by(direction, sortBy);
    List<CarShowroomEntity> carShowroomEntityList = carShowroomRepository.findAll(sort);
    List<CarShowroomDTO> carShowroomDTOList = carShowroomMapper.convertToCarShowroomDTOList(carShowroomEntityList);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(new API_Responses<>(200, "Get All Car Showroom Sorted by " + sortBy + " And " + sortDirection, carShowroomDTOList));
  }
}
