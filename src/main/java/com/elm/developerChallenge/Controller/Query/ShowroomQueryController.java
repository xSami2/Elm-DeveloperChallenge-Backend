package com.elm.developerChallenge.Controller.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.ShowroomDTO;
import com.elm.developerChallenge.Service.Query.ShowroomQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/carshowroom")
public class ShowroomQueryController {

  private final ShowroomQueryServiceImpl carShowroomQueryService;

    @GetMapping("")
    public ResponseEntity<API_Responses<Page>> getAllCarShowrooms(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam() String sortBy) {  // Accepting sort parameter
        return carShowroomQueryService.getAllCarShowrooms(page, size ,sortBy);
    }


    @GetMapping("/names")
  public ResponseEntity<API_Responses<List<ShowroomDTO>>> getAllCarShowroomsNames() {
    return carShowroomQueryService.getAllCarShowroomsNames();
  }

  @GetMapping("/{id}")
  public ResponseEntity<API_Responses<ShowroomDTO>> getCarShowroom(@PathVariable String id) {
    return carShowroomQueryService.getCarShowroom(id);
  }

  @GetMapping("/sorted")
  public ResponseEntity<API_Responses<Page>> getSortedCarShowrooms(
       @RequestParam String sortBy, @RequestParam String sortDirection , @RequestParam int pageNumber) {
    System.out.println(sortBy + " " + sortDirection + " " + pageNumber);
    System.out.println(pageNumber);
    return carShowroomQueryService.getAllActiveCarShowroomsSorted(pageNumber ,sortBy, sortDirection);
  }
}
