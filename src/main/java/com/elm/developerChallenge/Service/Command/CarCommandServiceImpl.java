package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Request.Car.SaveCarRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Car.SaveCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Mapper.CarMapper;
import com.elm.developerChallenge.Repository.CarRepository;
import com.elm.developerChallenge.Repository.ShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarCommandServiceImpl {

    private final CarRepository carRepository;
    private final CarMapper carMapper;


   public ResponseEntity<API_Responses<SaveCarResponsesDTO>> saveCar(SaveCarRequestDTO saveCarRequestDTO) {



       CarEntity carEntity = carMapper.convertToCarEntity(saveCarRequestDTO);


       CarEntity savedCarEntity = carRepository.save(carEntity);
       SaveCarResponsesDTO saveCarResponsesDTO = carMapper.convertToDTO(savedCarEntity);

       return ResponseEntity
               .status(HttpStatus.CREATED)
               .body(
                       new API_Responses<>( 201 , "Car successfully saved" ,saveCarResponsesDTO )
               );

    }

    public ResponseEntity<API_Responses<String>> deleteCar(String carId) {

        Optional<CarEntity> optionalCarEntity = carRepository.findById(carId);

        // Check if Car is Exist
        if (optionalCarEntity.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new API_Responses<>(404,
                            "The requested car was not found in the system.",
                            null)
            );
        }
        carRepository.deleteById(carId);


        return ResponseEntity.status(HttpStatus.OK).body(
                new API_Responses<>(200,
                        "The requested car has been deleted from the system.",
                        "")
        );
    }
}
