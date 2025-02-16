package com.elm.developerChallenge.Controller.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Showroom.SaveShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.SaveShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomResponsesDTO;
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
    public ResponseEntity<API_Responses<SaveShowroomResponsesDTO>> saveShowroom(@Valid @RequestBody SaveShowroomRequestDTO saveShowroomRequestDTO){
        return showroomCommandService.saveCarShowroom(saveShowroomRequestDTO);
    }

    @PutMapping("")
    public ResponseEntity<API_Responses<UpdateShowroomResponsesDTO>> updateShowroom(@Valid @RequestBody UpdateShowroomRequestDTO updateShowroomRequestDTO){
        return showroomCommandService.updateShowroom(updateShowroomRequestDTO);
    }

    @DeleteMapping("/{ShowroomID}")
    public ResponseEntity<API_Responses<String>> deleteShowroom(@PathVariable String ShowroomID){
        return showroomCommandService.deleteCarShowroom(ShowroomID);
    }


}
