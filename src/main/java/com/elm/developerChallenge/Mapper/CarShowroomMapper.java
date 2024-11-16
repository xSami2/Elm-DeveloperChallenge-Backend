package com.elm.developerChallenge.Mapper;

import com.elm.developerChallenge.DTO.CarShowroomDTO;
import com.elm.developerChallenge.Entity.CarShowroomEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CarShowroomMapper {

    private final ObjectMapper mapper;

    public CarShowroomEntity convertToCarShowroomEntity(CarShowroomDTO carShowroomDTO) {
        return mapper.convertValue(carShowroomDTO, CarShowroomEntity.class);
    }

    public CarShowroomDTO convertToCarShowroomDTO(CarShowroomEntity carShowroomEntity) {
        return mapper.convertValue(carShowroomEntity, CarShowroomDTO.class);
    }
}
