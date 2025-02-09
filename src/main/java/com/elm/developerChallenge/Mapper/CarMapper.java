package com.elm.developerChallenge.Mapper;

import com.elm.developerChallenge.DTO.CarDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CarMapper {


    private final ObjectMapper mapper;

    public CarEntity convertToCarEntity(CarDTO carDTO) {
        return mapper.convertValue(carDTO, CarEntity.class);
    }

    public CarDTO convertToCarDTO(CarEntity carEntity) {
        return mapper.convertValue(carEntity, CarDTO.class);
    }

    public List<CarDTO> convertToCarDTOList(List<CarEntity> carEntityList) {
        return carEntityList.stream().map(
                carEntity    -> mapper.convertValue( carEntity , CarDTO.class)
        ).collect(Collectors.toList());
    }
}
