package com.elm.developerChallenge.Controller.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Service.Command.CarShowroomCommandServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController()
@RequestMapping("/carshowroom")
public class CarShowroomCommandController {

    private final CarShowroomCommandServiceImpl carShowroomCommandService;

    @PostMapping("")
    public ResponseEntity<API_Responses<CarShowroomDTO>> createCarShowroom(@Valid @RequestBody CarShowroomDTO carShowroomDTO){
        return carShowroomCommandService.saveCarShowroom(carShowroomDTO);
    }

    @DeleteMapping("/{carShowroomID}")
    public ResponseEntity<API_Responses<CarShowroomDTO>> deleteCarShowroom(@PathVariable String carShowroomID){
        return carShowroomCommandService.deleteCarShowroom(carShowroomID);
    }


}
