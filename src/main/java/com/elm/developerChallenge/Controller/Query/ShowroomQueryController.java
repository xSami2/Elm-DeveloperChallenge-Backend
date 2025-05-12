package com.elm.developerChallenge.Controller.Query;

import com.elm.developerChallenge.Controller.Query.Interface.IShowroomQueryController;
import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Respones.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.GetShowroomResponsesDTO;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.elm.developerChallenge.Service.Query.ShowroomQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/showroom")
public class ShowroomQueryController implements IShowroomQueryController {

  private final ShowroomQueryServiceImpl showroomQueryService;

    @GetMapping("")
    public ResponseEntity<API_Responses<PagedModel<EntityModel<GetAllShowroomResponsesDTO>>>> getAllShowroom(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
//            @RequestParam(defaultValue = "ASC") String sortDirection,
//            @RequestParam(defaultValue = "updated_at") String sortField
            ) {
        return showroomQueryService.getAllShowroom(page, size);
    }




  @GetMapping("/{id}")
  public ResponseEntity<API_Responses<GetShowroomResponsesDTO>> getShowroomById(@PathVariable String id) {
    return showroomQueryService.getShowroomById(id);
  }


}
