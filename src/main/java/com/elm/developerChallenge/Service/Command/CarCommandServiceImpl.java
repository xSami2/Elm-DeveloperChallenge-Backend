package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.ShowroomEntity;
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

    private final ShowroomRepository showroomRepository;
    private final CarRepository carRepository;
    private final CarMapper carMapper;


   public ResponseEntity<API_Responses<CarDTO>> saveCar(CarDTO carDTO) {
       String carShowroomId = carDTO.getCarShowroom().getId();
       Optional<ShowroomEntity> optionalShowroomEntity = showroomRepository.findShowroomEntityById(carShowroomId);

       if (optionalShowroomEntity.isEmpty()) {
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body(
                           new API_Responses<>( 400 , "Could not save Car" ,null )
                   );
       }


       CarEntity carEntity = carMapper.convertToCarEntity(carDTO);

       ShowroomEntity showroomEntity = optionalShowroomEntity.get();
       carEntity.setShowroom(showroomEntity);
       CarEntity savedCarEntity = carRepository.save(carEntity);
       CarDTO    savedCarDTO = carMapper.convertToCarDTO(savedCarEntity);

       return ResponseEntity
               .status(HttpStatus.OK)
               .body(
                       new API_Responses<>( 201 , "save Car" ,savedCarDTO )
               );

    }

}
