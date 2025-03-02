package com.elm.developerChallenge.Controller.Command.Interface;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Request.Showroom.SaveShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.SaveShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Request.Showroom.UpdateShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.UpdateShowroomResponsesDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public interface IShowroomCommandController {

    @PostMapping()
    @Operation(
            summary = "Save a new Showroom",
            description = "This endpoint allows you to save a new Showroom into the system.",
            tags = {"Showroom Controller"},
            responses = {
                    @ApiResponse(
                            description = "Showroom successfully saved",
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
    public ResponseEntity<API_Responses<SaveShowroomResponsesDTO>> saveShowroom(@Valid @RequestBody SaveShowroomRequestDTO saveShowroomRequestDTO);

    @PutMapping()
    @Operation(
            summary = "Update Showroom",
            description = "This endpoint allows you to Update a Showroom in the system.",
            tags = {"Showroom Controller"},
            responses = {
                    @ApiResponse(
                            description = "Showroom successfully updated",
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
                    @ApiResponse(
                            description = "The showroom with the provided ID could not be found. Please verify if showroom is exists and try again",
                            responseCode = "404"
                    ),
            }
    )
    public ResponseEntity<API_Responses<UpdateShowroomResponsesDTO>> updateShowroom(@Valid @RequestBody UpdateShowroomRequestDTO updateShowroomRequestDTO);


    @DeleteMapping("/{ShowroomID}")
    @Operation(
            summary = "Delete Showroom",
            description = "This endpoint allows you to Delete a Showroom in the system.",
            tags = {"Showroom Controller"},
            responses = {
                    @ApiResponse(
                            description = "Showroom successfully Delete",
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
                    @ApiResponse(
                            description = "The showroom with the provided ID could not be found. Please verify if showroom is exists and try again",
                            responseCode = "404"
                    ),
            }
    )
    public ResponseEntity<API_Responses<String>> deleteShowroom(@PathVariable String ShowroomID);

    }
