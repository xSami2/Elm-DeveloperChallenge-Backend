package com.elm.developerChallenge.Controller.Query;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Service.Query.CarQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/car")
@RestController
public class CarQueryController {

    private final CarQueryServiceImpl carQueryService;

    @GetMapping("")
    public ResponseEntity<API_Responses<Page>> getAllCar(  @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "10") int size){
        return carQueryService.getAllCar(page , size);
    }

    @GetMapping("/byCarshowroom/{carShowroomId}")
    public ResponseEntity<API_Responses<List<CarDTO>>> getAllCarByShowroom(@PathVariable String carShowroomId){
        return carQueryService.getAllCarByShowroom(carShowroomId);
    }

    @RestController
    @RequestMapping("/cars")
    public class CarController {



        @GetMapping("/filter")
        public ResponseEntity<API_Responses<List<CarDTO>>> filterCars(
                @RequestParam(required = false) String maker,
                @RequestParam(required = false) String model,
                @RequestParam(required = false) String modelYear,
                @RequestParam(required = false) String carShowroom,
                @RequestParam(required = false) Double price  // Optional filter for minimum price
        ) {
           return carQueryService.getCars(maker,model,modelYear,carShowroom,price);
        }
    }





}
