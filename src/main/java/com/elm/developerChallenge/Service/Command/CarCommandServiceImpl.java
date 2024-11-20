package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarMapper;
import com.elm.developerChallenge.Repository.CarRepository;
import com.elm.developerChallenge.Repository.CarShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CarCommandServiceImpl {

    private final CarShowroomRepository carShowroomRepository;
    private final CarRepository carRepository;
    private final CarMapper carMapper;


   public ResponseEntity<API_Responses<CarDTO>> saveCar(CarDTO carDTO) {
       System.out.println(carDTO);
       String carShowroomId = carDTO.getCarShowroom().getId();
       Optional<CarShowroomEntity> optionalCarShowroomEntity = carShowroomRepository.findCarShowroomEntityById(carShowroomId);

       if (optionalCarShowroomEntity.isPresent()) {
           CarShowroomEntity carShowroomEntity = optionalCarShowroomEntity.get();
           CarEntity carEntity = carMapper.convertToCarEntity(carDTO);
           carEntity.setCarShowroom(carShowroomEntity);
           CarEntity savedCarEntity = carRepository.save(carEntity);
           CarDTO    savedCarDTO = carMapper.convertToCarDTO(savedCarEntity);
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(
                           new API_Responses<>( 201 , "save Car" ,savedCarDTO )
                   );
       }


       return ResponseEntity
               .status(HttpStatus.BAD_REQUEST)
               .body(
                       new API_Responses<>( 400 , "Could not save Car" ,null )
               );
    }

}
