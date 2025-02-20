package com.elm.developerChallenge.Controller.Query.Interface;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.ShowroomDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IShowroomQueryController {


    @GetMapping("")
    @Operation(
            summary = "This End point is for Retrieve Showroom with  Ability for Sorting",
            tags = {"Showroom Controller"},
            responses = @ApiResponse(
                    description = "Get All Showrooms",
                    responseCode = "200"
            )
    )
    public ResponseEntity<API_Responses<Page<GetAllShowroomResponsesDTO>>> getAllShowroom(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDirection,
            @RequestParam(defaultValue = "updated_at") String sortField,
            @RequestParam(defaultValue = "" , required = false) String showroomName
    );



    @GetMapping("/{id}")
    @Operation(
            summary = "This end point for retrieve single showroom",
            tags = {"Showroom Controller"},
            responses ={
            @ApiResponse(
                    description = "Get Showroom OK",
                    responseCode = "200"
            ),
            @ApiResponse(
              description = "Could not find Showroom with the provided id",
              responseCode = "404"
            )
            }
    )
    public ResponseEntity<API_Responses<ShowroomDTO>> getShowroom(@PathVariable String id);
}
