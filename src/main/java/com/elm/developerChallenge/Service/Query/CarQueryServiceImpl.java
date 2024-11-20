package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarMapper;
import com.elm.developerChallenge.Mapper.CarShowroomMapper;
import com.elm.developerChallenge.Repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarQueryServiceImpl {

    private final CarRepository carRepository;
    private final CarShowroomMapper carShowroomMapper;
    private final CarMapper carMapper;

    public ResponseEntity<API_Responses<List<CarDTO>>> getAllCar(){
       List<CarEntity> carEntityList = carRepository.findAllWithShowroom();
       List<CarDTO> carDTOList = carMapper.convertToCarDTOList(carEntityList);


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new API_Responses<>(200 , "getAllCar", carDTOList)
                );
    }

    public ResponseEntity<API_Responses<List<CarDTO>>> getAllCarByShowroom(String carShowroomId){
        System.out.println(carShowroomId);
        List<CarEntity> carEntityList = carRepository.findAllByCarShowroom_Id(carShowroomId);
        System.out.println(carEntityList);
        List<CarDTO> carDTOList = carMapper.convertToCarDTOList(carEntityList);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new API_Responses<>(200 , "getAllCarByShowroom", carDTOList)
                );

    }

}
