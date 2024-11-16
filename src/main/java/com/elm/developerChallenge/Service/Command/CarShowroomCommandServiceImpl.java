package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
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
        CarShowroomEntity createdCarShowroomEntity = carShowroomRepository.save(carShowroomEntity);
        CarShowroomDTO createdCarShowroomDTO = carShowroomMapper.convertToCarShowroomDTO(createdCarShowroomEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new API_Responses<CarShowroomDTO>(201 , "Created" , createdCarShowroomDTO));
    }

}
