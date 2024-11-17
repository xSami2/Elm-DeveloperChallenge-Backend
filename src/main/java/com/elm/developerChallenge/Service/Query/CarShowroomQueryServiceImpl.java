package com.elm.developerChallenge.Service.Query;

import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarShowroomMapper;
import com.elm.developerChallenge.Repository.CarShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarShowroomQueryServiceImpl {

    private final CarShowroomRepository carShowroomRepository;
    private final CarShowroomMapper carShowroomMapper;


    public ResponseEntity<API_Responses<List<CarShowroomDTO>>> getAllCarShowrooms() {
        List<CarShowroomDTO> carShowroomDTOList = carShowroomRepository.findAllActiveCarShowrooms();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new API_Responses<>(
                        200 , "Get All Car Showrooms", carShowroomDTOList)
                );
    }
}
