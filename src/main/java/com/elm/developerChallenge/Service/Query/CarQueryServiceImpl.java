package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Respones.Car.GetAllCarResponsesDTO;
import com.elm.developerChallenge.DTO.Request.Specification.CarFilter;
import com.elm.developerChallenge.DTO.Respones.Car.GetCarResponsesDTO;
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

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarQueryServiceImpl {

  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public ResponseEntity<API_Responses<Page<GetAllCarResponsesDTO>>> getAllCar(int page, int size ,  String maker , String model , String modelYear , String carShowroom,Double price) {

      CarFilter carFilter = new CarFilter(maker,model,modelYear,price,carShowroom);
      Specification<CarEntity> spec = CarSpecification.createSpecification(carFilter);


      Pageable pageable = PageRequest.of(page, size);

    Page<CarEntity> carEntityPage = carRepository.findAll(spec ,pageable);

    // Convert From pageableCarEntity to GetAllCarResponsesDTO
    Page<GetAllCarResponsesDTO> getAllCarResponsesDTOS = carMapper.convertToDTO(carEntityPage);
    System.out.println(getAllCarResponsesDTOS);


    return ResponseEntity.status(HttpStatus.OK)
        .body(
                new API_Responses<>(
                        200,
                        "Successfully retrieved all cars.",
                        getAllCarResponsesDTOS)
        );
  }


    public ResponseEntity<API_Responses<GetCarResponsesDTO>> getCar(String carId) {
        Optional<CarEntity> optionalCarEntity = carRepository.findById(carId);

      // Check if Car is Exist
        if (optionalCarEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new API_Responses<>(404,
                            "The requested car was not found in the system.",
                            null)
            );
        }

        CarEntity carEntity = optionalCarEntity.get();
        GetCarResponsesDTO getCarResponsesDTO = carMapper.convertToGetCarResponsesDTO(carEntity);

        return ResponseEntity.status(HttpStatus.OK).body(
                new API_Responses<>(200,
                        "The requested car was not found in the system.",
                        getCarResponsesDTO)
        );


    }
}
