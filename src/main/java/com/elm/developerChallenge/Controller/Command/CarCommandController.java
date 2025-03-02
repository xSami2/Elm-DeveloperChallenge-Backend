package com.elm.developerChallenge.Controller.Command;


import com.elm.developerChallenge.Controller.Command.Interface.ICarCommandController;
import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Request.Car.SaveCarRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Car.SaveCarResponsesDTO;
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
public class CarCommandController implements ICarCommandController {

    private final CarCommandServiceImpl carCommandService;

    @PostMapping()
    @Override
    public ResponseEntity<API_Responses<SaveCarResponsesDTO>> saveCar(@Valid @RequestBody SaveCarRequestDTO saveCarRequestDTO) {
        return carCommandService.saveCar(saveCarRequestDTO);
    }

}
