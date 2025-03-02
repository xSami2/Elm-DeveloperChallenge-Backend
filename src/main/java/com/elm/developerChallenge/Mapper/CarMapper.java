package com.elm.developerChallenge.Mapper;

import com.elm.developerChallenge.DTO.Respones.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.DTO.Request.Car.SaveCarRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Car.SaveCarResponsesDTO;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public SaveCarResponsesDTO convertToDTO(CarEntity carEntity) {
        SaveCarResponsesDTO saveCarResponsesDTO = mapper.convertValue(carEntity , SaveCarResponsesDTO.class);
        saveCarResponsesDTO.setCarShowroomId(carEntity.getShowroom().getId());
        return saveCarResponsesDTO;
    }
    public Page<GetCarResponsesDTO> convertToDTO(Page<CarEntity> carEntities){
       List<GetCarResponsesDTO> getCarResponsesDTOList = carEntities.getContent()
               .stream()
               .map(CarEntity -> {
                 return  mapper.convertValue(CarEntity , GetCarResponsesDTO.class);
               }
               ).toList();
        return new PageImpl<>(getCarResponsesDTOList, carEntities.getPageable(), carEntities.getTotalElements());


    }



}
