package com.elm.developerChallenge.Controller.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.Service.Command.CarCommandServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/car")
@RestController
public class CarCommandController {

    private final CarCommandServiceImpl carCommandService;

    @PostMapping("")
    ResponseEntity<API_Responses<CarDTO>> saveCar(@Valid @RequestBody CarDTO carDTO) {
        return carCommandService.saveCar(carDTO);
    }

}
