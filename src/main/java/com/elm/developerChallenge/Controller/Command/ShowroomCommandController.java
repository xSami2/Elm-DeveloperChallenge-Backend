package com.elm.developerChallenge.Controller.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.ShowroomDTO;
import com.elm.developerChallenge.Service.Command.ShowroomCommandServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController()
@RequestMapping("/showroom")
public class ShowroomCommandController {

    private final ShowroomCommandServiceImpl showroomCommandService;

    @PostMapping("")
    public ResponseEntity<API_Responses<ShowroomDTO>> saveShowroom(@Valid @RequestBody ShowroomDTO showroomDTO){
        return showroomCommandService.saveCarShowroom(showroomDTO);
    }

    @PutMapping("")
    public ResponseEntity<API_Responses<ShowroomDTO>> updateShowroom(@Valid @RequestBody ShowroomDTO showroomDTO){
        return showroomCommandService.updateShowroom(showroomDTO);
    }

    @DeleteMapping("/{ShowroomID}")
    public ResponseEntity<API_Responses<ShowroomDTO>> deleteShowroom(@PathVariable String ShowroomID){
        return showroomCommandService.deleteCarShowroom(ShowroomID);
    }


}
