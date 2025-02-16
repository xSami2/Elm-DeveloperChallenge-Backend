package com.elm.developerChallenge.Mapper;

import com.elm.developerChallenge.DTO.Car.SaveCarRequestDTO;
import com.elm.developerChallenge.DTO.Car.SaveCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CarMapper {


    private final ObjectMapper mapper;

    // DTO => Entity


    public CarEntity convertToCarEntity(SaveCarRequestDTO saveCarRequestDTO) {
        CarEntity carEntity =  mapper.convertValue(saveCarRequestDTO, CarEntity.class);

        ShowroomEntity showroomEntity = new ShowroomEntity();
        showroomEntity.setId(saveCarRequestDTO.getCarShowroomId());
        carEntity.setShowroom(showroomEntity);

        return carEntity;
    }



    // Entity => DTO
    public SaveCarResponsesDTO convertToCarDTO(CarEntity carEntity) {
        SaveCarResponsesDTO saveCarResponsesDTO = mapper.convertValue(carEntity , SaveCarResponsesDTO.class);
        saveCarResponsesDTO.setCarShowroomId(carEntity.getShowroom().getId());
        return saveCarResponsesDTO;
    }



}
