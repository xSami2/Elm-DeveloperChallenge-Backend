package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.elm.developerChallenge.Mapper.CarShowroomMapper;
import com.elm.developerChallenge.Repository.CarShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class CarShowroomCommandServiceImpl {


    private final CarShowroomRepository carShowroomRepository;
    private final CarShowroomMapper carShowroomMapper;


    public ResponseEntity<API_Responses<CarShowroomDTO>> createCarShowroom(CarShowroomDTO carShowroomDTO) {

        if (carShowroomDTO.getUuid() != null && carShowroomRepository.existsById(UUID.fromString(carShowroomDTO.getUuid()))) {

            // Update Logic
            CarShowroomEntity carShowroomEntity = carShowroomMapper.convertToCarShowroomEntity(carShowroomDTO);
            CarShowroomEntity updatedCarShowroomEntity = carShowroomRepository.save(carShowroomEntity);
            CarShowroomDTO updatedCarShowroomDTO = carShowroomMapper.convertToCarShowroomDTO(updatedCarShowroomEntity);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new API_Responses<>(200, "Updated", updatedCarShowroomDTO));
        }

        // Check if the Commercial Registration Number is already taken
        Optional<CarShowroomEntity> existingCarShowroom = carShowroomRepository
                .findCarShowroomEntityByIdAndActiveTrue(carShowroomDTO.getCommercialRegistrationNumber());

        if (existingCarShowroom.isPresent()) {
            // If the Commercial Registration Number is taken, return an error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new API_Responses<>(400, "Commercial Registration Number Already Taken", null));
        }

        // Create Logic: Convert DTO to entity and save it
        CarShowroomEntity carShowroomEntity = carShowroomMapper.convertToCarShowroomEntity(carShowroomDTO);
        CarShowroomEntity savedCarShowroomEntity = carShowroomRepository.save(carShowroomEntity);
        CarShowroomDTO    savedCarShowroomDTO = carShowroomMapper.convertToCarShowroomDTO(savedCarShowroomEntity);


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new API_Responses<>(201, "Created", savedCarShowroomDTO));
    }

}
