package com.elm.developerChallenge.Controller.Query;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Service.Query.CarQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/car")
@RestController
public class CarQueryController {

    private final CarQueryServiceImpl carQueryService;

    @GetMapping("")
    public ResponseEntity<API_Responses<List<CarDTO>>> getAllCar(){
        return carQueryService.getAllCar();
    }

    @GetMapping("/byCarshowroom/{carShowroomId}")
    public ResponseEntity<API_Responses<List<CarDTO>>> getAllCarByShowroom(@PathVariable String carShowroomId){
        return carQueryService.getAllCarByShowroom(carShowroomId);
    }



}
