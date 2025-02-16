package com.elm.developerChallenge.Controller.Query;


import com.elm.developerChallenge.Controller.Query.Interface.ICarQueryController;
import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Service.Query.CarQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RequestMapping("/car")
@RestController
public class CarQueryQueryController implements ICarQueryController {

    private final CarQueryServiceImpl carQueryService;

    @Override
    @GetMapping()
    public ResponseEntity<API_Responses<Page<GetCarResponsesDTO>>> getAllCar(
                                                        @RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size){
        return carQueryService.getAllCar(page , size);
    }



        @Override
        @GetMapping("/filter")
        public ResponseEntity<API_Responses<Page<CarEntity>>> getFilteredCars(
                @RequestParam(required = false) String maker,
                @RequestParam(required = false) String model,
                @RequestParam(required = false) String modelYear,
                @RequestParam(required = false) String carShowroom,
                @RequestParam(required = false) Double price
        ) {
           return carQueryService.getFilteredCars(maker,model,modelYear,carShowroom,price);
        }






}
