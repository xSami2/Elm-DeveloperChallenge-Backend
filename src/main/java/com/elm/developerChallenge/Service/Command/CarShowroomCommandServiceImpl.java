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


    public ResponseEntity<API_Responses<CarShowroomDTO>> saveCarShowroom(CarShowroomDTO carShowroomDTO) {
        Optional<CarShowroomEntity> existingCommercialRegistrationNumber = carShowroomRepository
                .findCarShowroomEntityById(carShowroomDTO.getCommercialRegistrationNumber());

        if (existingCommercialRegistrationNumber.isPresent()) {
            CarShowroomEntity existingEntity = existingCommercialRegistrationNumber.get();
            if (existingEntity.getId().equals(carShowroomDTO.getId())) {
                return handleUpdate(carShowroomDTO);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new API_Responses<>(400, "Commercial Registration Number Already Taken", null));
        }

        if (carShowroomDTO.getId() != null) {
            return handleUpdate(carShowroomDTO);
        }

        return handleCreate(carShowroomDTO);
    }

    public ResponseEntity<API_Responses<CarShowroomDTO>> deleteCarShowroom(String carShowroomId) {
        Optional<CarShowroomEntity> optionalCarShowroomEntity  = carShowroomRepository.findCarShowroomEntityById(carShowroomId);

        if (optionalCarShowroomEntity.isPresent()) {
            CarShowroomEntity carShowroomEntity = optionalCarShowroomEntity.get();
            carShowroomEntity.setActive(false);
            carShowroomRepository.save(carShowroomEntity);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new API_Responses<>(200, "Car Showroom Deleted", null));
        }


        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new API_Responses<>(404, "Could not found Car Showroom With ID : " + carShowroomId, null));
    }

    private ResponseEntity<API_Responses<CarShowroomDTO>> handleUpdate(CarShowroomDTO carShowroomDTO) {
        CarShowroomEntity carShowroomEntity = carShowroomMapper.convertToCarShowroomEntity(carShowroomDTO);
        CarShowroomEntity savedCarShowroomEntity = carShowroomRepository.save(carShowroomEntity);
        CarShowroomDTO savedCarShowroomDTO = carShowroomMapper.convertToCarShowroomDTO(savedCarShowroomEntity);
        return ResponseEntity.status(HttpStatus.OK)  // Status 200 for updates
                .body(new API_Responses<>(200, "Updated", savedCarShowroomDTO));  // Fixed typo here
    }

    private ResponseEntity<API_Responses<CarShowroomDTO>> handleCreate(CarShowroomDTO carShowroomDTO) {
        CarShowroomEntity carShowroomEntity = carShowroomMapper.convertToCarShowroomEntity(carShowroomDTO);
        CarShowroomEntity savedCarShowroomEntity = carShowroomRepository.save(carShowroomEntity);
        CarShowroomDTO savedCarShowroomDTO = carShowroomMapper.convertToCarShowroomDTO(savedCarShowroomEntity);
        return ResponseEntity.status(HttpStatus.CREATED)  // Status 201 for creation
                .body(new API_Responses<>(201, "Created", savedCarShowroomDTO));
    }


}
