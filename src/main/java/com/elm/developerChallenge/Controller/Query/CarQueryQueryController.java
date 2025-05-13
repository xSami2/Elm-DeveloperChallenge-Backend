package com.elm.developerChallenge.Controller.Query;


import com.elm.developerChallenge.Controller.Query.Interface.ICarQueryController;
import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Respones.Car.GetAllCarResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Service.Query.CarQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/cars")
@RestController
public class CarQueryQueryController implements ICarQueryController {

    private final CarQueryServiceImpl carQueryService;

    @GetMapping
    public ResponseEntity<API_Responses<Page<GetAllCarResponsesDTO>>> getAllCar(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String maker,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String modelYear,
            @RequestParam(required = false) String carShowroom,
            @RequestParam(required = false) Double price
    ) {
        // if no filters, return all cars
        // if any filters present, apply filtering logic
        return carQueryService.getAllCar(page, size, maker, model, modelYear, carShowroom, price);
    }

    @GetMapping("/{carId}")
    public ResponseEntity<API_Responses<GetCarResponsesDTO>> getCar(@PathVariable String carId){
        return carQueryService.getCar(carId);
    }







}
