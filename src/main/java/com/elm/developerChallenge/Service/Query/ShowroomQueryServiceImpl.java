package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Respones.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.GetShowroomResponsesDTO;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.elm.developerChallenge.Mapper.ShowroomMapper;
import com.elm.developerChallenge.Repository.ShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShowroomQueryServiceImpl {

  private final ShowroomRepository showroomRepository;
  private final ShowroomMapper showroomMapper;
 // private final List<String> validSortFields = Arrays.asList("id" , "name" , )

  public ResponseEntity<API_Responses<Page<ShowroomEntity>>> getAllShowroom(int page , int size , String sortDirection , String sortField) {

    Sort.Direction SortDirectionObject;

    try{

      SortDirectionObject = Sort.Direction.fromString(sortDirection);

    } catch (IllegalArgumentException e){
      SortDirectionObject = Sort.Direction.ASC;
    }

    Sort sort = Sort.by(SortDirectionObject, sortField);

    Pageable pageable = PageRequest.of(page, size, sort);



    Page<ShowroomEntity> pageableAllShowroomEntity  = showroomRepository.findAll(pageable);
   // Page<GetAllShowroomResponsesDTO> allShowroomDTOs = showroomMapper.convertToDTO(pageableAllShowroomEntity);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new API_Responses<>(200, "Get All Showrooms", pageableAllShowroomEntity));
  }

  public ResponseEntity<API_Responses<GetShowroomResponsesDTO>> getShowroom(String uuid) {
    Optional<ShowroomEntity> optionalCarShowroomEntity =
        showroomRepository.findShowroomEntityById(uuid);

    if (optionalCarShowroomEntity.isPresent()) {
      ShowroomEntity carShowroomEntity = optionalCarShowroomEntity.get();
      GetShowroomResponsesDTO getShowroomResponsesDTO = showroomMapper.convertToCarShowroomDTO(carShowroomEntity);
      return ResponseEntity.status(HttpStatus.OK)
          .body(new API_Responses<>(200, "Get Car Showroom", getShowroomResponsesDTO));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new API_Responses<>(404, "Could not find Car Showroom with id : " + uuid, null));
  }

}
