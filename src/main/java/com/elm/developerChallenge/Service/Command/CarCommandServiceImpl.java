package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Car.SaveCarRequestDTO;
import com.elm.developerChallenge.DTO.Car.SaveCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Mapper.CarMapper;
import com.elm.developerChallenge.Repository.CarRepository;
import com.elm.developerChallenge.Repository.ShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarCommandServiceImpl {

    private final ShowroomRepository showroomRepository;
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

}
