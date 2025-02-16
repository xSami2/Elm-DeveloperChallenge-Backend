package com.elm.developerChallenge.Controller.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.ShowroomDTO;
import com.elm.developerChallenge.Service.Query.ShowroomQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/showroom")
public class ShowroomQueryController {

  private final ShowroomQueryServiceImpl carShowroomQueryService;

    @GetMapping("")
    public ResponseEntity<API_Responses<Page<GetAllShowroomResponsesDTO>>> getAllShowroom(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "ASC") String sortDirection,
            @RequestParam(defaultValue = "updated_at") String sortField
            ) {
        return carShowroomQueryService.getAllShowroom(page, size ,sortDirection , sortField);
    }


    @GetMapping("/names")
  public ResponseEntity<API_Responses<List<ShowroomDTO>>> getAllCarShowroomsNames() {
    return carShowroomQueryService.getAllCarShowroomsNames();
  }

  @GetMapping("/{id}")
  public ResponseEntity<API_Responses<ShowroomDTO>> getCarShowroom(@PathVariable String id) {
    return carShowroomQueryService.getCarShowroom(id);
  }


}
