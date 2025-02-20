package com.elm.developerChallenge.Controller.Query.Interface;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/car")
public interface ICarQueryController {




    @GetMapping()
    @Operation(
            summary = "Get All Cars",
            description = "This endpoint allows you to get all cars in the system.",
            tags = {"Car Controller"},
            responses = {
                    @ApiResponse(
                            description = "Successfully retrieved all cars.",
                            responseCode = "200"
                    ),
            }
    )
    public ResponseEntity<API_Responses<Page<GetCarResponsesDTO>>> getAllCar(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @Operation(
            summary = "Get Cars with Filters",
            description = "This endpoint allows you to get cars filtered by optional parameters such as maker, model, model year, showroom, and price.",
            tags = {"Car Controller"},
            responses = {
                    @ApiResponse(
                            description = "Successfully retrieved filtered cars.",
                            responseCode = "200"
                    ),
            },
            parameters = {
                    @Parameter(name = "maker", description = "Filter cars by maker", required = false),
                    @Parameter(name = "model", description = "Filter cars by model", required = false),
                    @Parameter(name = "modelYear", description = "Filter cars by model year", required = false),
                    @Parameter(name = "carShowroomId", description = "Filter cars by showroom", required = false),
                    @Parameter(name = "price", description = "Filter cars by price", required = false)
            }
    )
    @GetMapping("/filter")
    public ResponseEntity<API_Responses<Page<GetCarResponsesDTO>>> getFilteredCars(
            @RequestParam(required = false) String maker,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) String modelYear,
            @RequestParam(required = false) String carShowroomId,
            @RequestParam(required = false) Double price
    );


}
