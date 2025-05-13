package com.elm.developerChallenge.Controller.Query.Interface;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Respones.Car.GetAllCarResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/cars")
public interface ICarQueryController {




    @GetMapping()
    @Operation(
            summary = "Get All Cars",
            description = "This endpoint allows you to get all cars in the system.",
            tags = {"Car Controller"}
    )
    public ResponseEntity<API_Responses<Page<GetAllCarResponsesDTO>>> getAllCar(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size ,  @RequestParam(required = false) String maker,
                                                                                @RequestParam(required = false) String model,
                                                                                @RequestParam(required = false) String modelYear,
                                                                                @RequestParam(required = false) String carShowroom,
                                                                                @RequestParam(required = false) Double price);

    @GetMapping("/{carId}")
    @Operation(
            summary = "Get Car By Id",
            description = "This endpoint allows you to get Car By id in the system.",
            tags = {"Car Controller"}
    )
    public ResponseEntity<API_Responses<GetCarResponsesDTO>> getCar(@PathVariable String carId);



}
