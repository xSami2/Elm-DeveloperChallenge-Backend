package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.ShowroomDTO;
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

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShowroomQueryServiceImpl {

  private final ShowroomRepository ShowroomRepository;
  private final ShowroomMapper carShowroomMapper;
 // private final List<String> validSortFields = Arrays.asList("id" , "name" , )

  public ResponseEntity<API_Responses<Page<GetAllShowroomResponsesDTO>>> getAllShowroom(int page , int size , String sortDirection , String sortField) {
    Sort.Direction SortDirectionObject;

    try{
      SortDirectionObject = Sort.Direction.fromString(sortDirection);
    }catch (IllegalArgumentException e){
      SortDirectionObject = Sort.Direction.ASC;
    }

    Sort sort = Sort.by(SortDirectionObject, sortField);

    Pageable pageable = PageRequest.of(page, size, sort);



    Page<GetAllShowroomResponsesDTO> carShowroomPage  = ShowroomRepository.findAllShowroom(pageable);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new API_Responses<>(200, "Get All Car Showrooms", carShowroomPage));
  }

  public ResponseEntity<API_Responses<List<ShowroomDTO>>> getAllCarShowroomsNames() {
    List<ShowroomEntity> carShowroomEntities = ShowroomRepository.findAll();
    List<ShowroomDTO> showroomDTOList = carShowroomMapper.convertToCarShowroomDTOList(carShowroomEntities);
    return ResponseEntity.status(HttpStatus.OK)
            .body(new API_Responses<>(200, "Get All Car Showrooms Names", showroomDTOList));
  }

  public ResponseEntity<API_Responses<ShowroomDTO>> getCarShowroom(String uuid) {
    Optional<ShowroomEntity> optionalCarShowroomEntity =
        ShowroomRepository.findShowroomEntityById(uuid);

    if (optionalCarShowroomEntity.isPresent()) {
      ShowroomEntity carShowroomEntity = optionalCarShowroomEntity.get();
      ShowroomDTO showroomDTO = carShowroomMapper.convertToCarShowroomDTO(carShowroomEntity);
      return ResponseEntity.status(HttpStatus.OK)
          .body(new API_Responses<>(200, "Get Car Showroom", showroomDTO));
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new API_Responses<>(404, "Could not find Car Showroom with id : " + uuid, null));
  }

  public ResponseEntity<API_Responses<Page<GetAllShowroomResponsesDTO>>> getAllActiveCarShowroomsSorted(int pageNumber,String sortBy , String sortDirection) {
    // Pageable is Return Entity , I must convert to DTO
    Sort.Direction direction = Sort.Direction.fromString(sortDirection);
    Sort sort = Sort.by(direction, sortBy);
    System.out.println();
    Pageable page = PageRequest.of(pageNumber , 10, sort);
    Page<GetAllShowroomResponsesDTO> carShowroomPage = ShowroomRepository.findAllShowroom(page);
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(new API_Responses<>(200, "Get All Car Showroom Sorted by " + sortBy + " And " + sortDirection, carShowroomPage));
  }
}
