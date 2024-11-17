package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarShowroomMapper;
import com.elm.developerChallenge.Repository.CarShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CarShowroomCommandServiceImpl {



    private final CarShowroomRepository carShowroomRepository;
    private final CarShowroomMapper carShowroomMapper;


    public ResponseEntity<API_Responses<CarShowroomDTO>> createCarShowroom(CarShowroomDTO carShowroomDTO){
        CarShowroomEntity carShowroomEntity = carShowroomMapper.convertToCarShowroomEntity(carShowroomDTO);
        CarShowroomEntity savedCarShowroomEntity = carShowroomRepository.save(carShowroomEntity);
        CarShowroomDTO savedCarShowroomDTO = carShowroomMapper.convertToCarShowroomDTO(savedCarShowroomEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new API_Responses<>(201 , "Created" , savedCarShowroomDTO));
    }

}
