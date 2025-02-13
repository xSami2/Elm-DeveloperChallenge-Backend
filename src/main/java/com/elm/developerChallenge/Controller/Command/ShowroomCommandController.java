package com.elm.developerChallenge.Controller.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Showroom.CreateShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.CreateShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomResponsesDTO;
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
    public ResponseEntity<API_Responses<CreateShowroomResponsesDTO>> saveShowroom(@Valid @RequestBody CreateShowroomRequestDTO createShowroomRequestDTO){
        return showroomCommandService.saveCarShowroom(createShowroomRequestDTO);
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
