package com.elm.developerChallenge.Controller.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Service.Query.CarShowroomQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/carshowroom")

public class CarShowroomQueryController {

    private final CarShowroomQueryServiceImpl carShowroomQueryService;

    @GetMapping("")
    public ResponseEntity<API_Responses<List<CarShowroomDTO>>> getAllCarShowrooms() {
        return carShowroomQueryService.getAllCarShowrooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<API_Responses<CarShowroomDTO>> getCarShowroom(@PathVariable String id) {
     return carShowroomQueryService.getCarShowroom(id);
    }

    @GetMapping("/sorted")
    public ResponseEntity<API_Responses<List<CarShowroomDTO>>> getSortedCarShowrooms(@RequestParam String sortBy , @RequestParam String sortDirection) {
        System.out.println(sortBy + " " + sortDirection);
        return carShowroomQueryService.getAllActiveCarShowroomsSorted(sortBy, sortDirection);
    }

}
