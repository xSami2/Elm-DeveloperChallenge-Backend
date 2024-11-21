package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.DTO.CarFilter;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarMapper;
import com.elm.developerChallenge.Mapper.CarShowroomMapper;
import com.elm.developerChallenge.Repository.CarRepository;
import com.elm.developerChallenge.Spec.CarSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CarQueryServiceImpl {

  private final CarRepository carRepository;
  private final CarShowroomMapper carShowroomMapper;
  private final CarMapper carMapper;

  public ResponseEntity<API_Responses<Page>> getAllCar(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);

    Page<CarEntity> carEntitiePage = carRepository.findAllWithShowroom(pageable);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new API_Responses<>(200, "getAllCar", carEntitiePage));
  }

  public ResponseEntity<API_Responses<List<CarDTO>>> getAllCarByShowroom(String carShowroomId) {
    System.out.println(carShowroomId);
    List<CarEntity> carEntityList = carRepository.findAllByCarShowroom_Id(carShowroomId);
    System.out.println(carEntityList);
    List<CarDTO> carDTOList = carMapper.convertToCarDTOList(carEntityList);
    return ResponseEntity.status(HttpStatus.OK)
        .body(new API_Responses<>(200, "getAllCarByShowroom", carDTOList));
  }

  public ResponseEntity<API_Responses<List<CarDTO>>> getCars(
          String maker , String model , String modelYear , String carShowroom,Double price
  ){
      CarFilter carFilter = new CarFilter(maker,model,modelYear,price,carShowroom);
      Specification<CarEntity> spec = CarSpec.createSpecification(carFilter);
        List<CarEntity> carEntityList = carRepository.findAll(spec);
        List<CarDTO> carDTOList = carMapper.convertToCarDTOList(carEntityList);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new API_Responses<>(200 , "GET" , carDTOList)
                );

  }
}
