package com.elm.developerChallenge.Controller.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Service.Query.CarShowroomQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class CarShowroomQueryController {

    private final CarShowroomQueryServiceImpl carShowroomQueryService;

    @GetMapping("/carShowrooms")
    public ResponseEntity<API_Responses<List<CarShowroomDTO>>> getAllCarShowrooms() {
        return carShowroomQueryService.getAllCarShowrooms();
    }

}
