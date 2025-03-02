package com.elm.developerChallenge.Controller.Command.Interface;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Request.Car.SaveCarRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Car.SaveCarResponsesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface ICarCommandController {


    @PostMapping()
    @Operation(
            summary = "Save a new car",
            description = "This endpoint allows you to save a new car into the system.",
            tags = {"Car Controller"},
            responses = {
                    @ApiResponse(
                            description = "Car successfully saved",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Invalid input data",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            example = "{\"fieldName\": \"Volatile Description\"}"
                                    )
                            )
                    ),
            }
    )
    ResponseEntity<API_Responses<SaveCarResponsesDTO>> saveCar(@Valid @RequestBody SaveCarRequestDTO saveCarRequestDTO);


}
