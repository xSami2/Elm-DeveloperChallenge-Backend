package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.DTO.CarFilter;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Mapper.CarMapper;
import com.elm.developerChallenge.Repository.CarRepository;
import com.elm.developerChallenge.Specification.CarSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarQueryServiceImpl {

  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public ResponseEntity<API_Responses<Page<GetCarResponsesDTO>>> getAllCar(int page, int size) {
    Pageable pageable = PageRequest.of(page, size);

    Page<GetCarResponsesDTO> carDTOPage = carRepository.findAllWithShowroom(pageable);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new API_Responses<>(200, "Successfully retrieved all cars.", carDTOPage));
  }


  public ResponseEntity<API_Responses<Page<CarEntity>>> getFilteredCars(
          String maker , String model , String modelYear , String carShowroom,Double price
  ){
      CarFilter carFilter = new CarFilter(maker,model,modelYear,price,carShowroom);
      Specification<CarEntity> spec = CarSpecification.createSpecification(carFilter);
      Pageable pageable = PageRequest.of(0, 10);
      Page<CarEntity> carEntities = carRepository.findAll(spec ,pageable);

        return ResponseEntity

                .status(HttpStatus.OK)
                .body(
                        new API_Responses<>(200 , "GET" , carEntities)
                );

  }
}
