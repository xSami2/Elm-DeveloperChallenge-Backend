package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarShowroomMapper;
import com.elm.developerChallenge.Repository.CarShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarShowroomQueryServiceImpl {

  private final CarShowroomRepository carShowroomRepository;
  private final CarShowroomMapper carShowroomMapper;

  public ResponseEntity<API_Responses<Page>> getAllCarShowrooms(int page , int size , String sortBy) {
    String [] sortFilitr = sortBy.split(",");
    Sort.Direction direction = Sort.Direction.fromString(sortFilitr[1]);
    Sort sort = Sort.by(direction, sortFilitr[0]);
    Pageable pageable = PageRequest.of(page, size , sort);

    Page<CarShowroomDTO> carShowroomPage  = carShowroomRepository.findAllCarShowrooms(pageable);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new API_Responses<>(200, "Get All Car Showrooms", carShowroomPage));
  }

  public ResponseEntity<API_Responses<List<CarShowroomDTO>>> getAllCarShowroomsNames() {
    List<CarShowroomEntity> carShowroomEntities = carShowroomRepository.findAll();
    List<CarShowroomDTO> carShowroomDTOList = carShowroomMapper.convertToCarShowroomDTOList(carShowroomEntities);
    return ResponseEntity.status(HttpStatus.OK)
            .body(new API_Responses<>(200, "Get All Car Showrooms Names", carShowroomDTOList));
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

  public ResponseEntity<API_Responses<Page>> getAllActiveCarShowroomsSorted(int pageNumber,String sortBy , String sortDirection) {
    Sort.Direction direction = Sort.Direction.fromString(sortDirection);
    Sort sort = Sort.by(direction, sortBy);
    System.out.println();
    Pageable page = PageRequest.of(pageNumber , 10, sort);
    Page<CarShowroomDTO> carShowroomPage = carShowroomRepository.findAllCarShowrooms(page);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(new API_Responses<>(200, "Get All Car Showroom Sorted by " + sortBy + " And " + sortDirection, carShowroomPage));
  }
}
