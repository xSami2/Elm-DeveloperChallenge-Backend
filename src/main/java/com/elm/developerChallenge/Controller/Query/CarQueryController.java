package com.elm.developerChallenge.Controller.Query;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Service.Query.CarQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
