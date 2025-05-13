package com.elm.developerChallenge.Mapper;

import com.elm.developerChallenge.DTO.Respones.Car.GetAllCarResponsesDTO;
import com.elm.developerChallenge.DTO.Request.Car.SaveCarRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Car.GetCarResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Car.SaveCarResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Car.ShowroomBasicInfo;
import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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
    public SaveCarResponsesDTO convertToDTO(CarEntity carEntity) {
        SaveCarResponsesDTO saveCarResponsesDTO = mapper.convertValue(carEntity , SaveCarResponsesDTO.class);


        saveCarResponsesDTO.setCarShowroomId(carEntity.getShowroom().getId());
        return saveCarResponsesDTO;
    }

    public GetCarResponsesDTO convertToGetCarResponsesDTO(CarEntity carEntity) {
        System.out.println("convertToGetCarResponsesDTO");
        System.out.println(carEntity.toString());
        GetCarResponsesDTO getCarResponsesDTO = mapper.convertValue(carEntity , GetCarResponsesDTO.class);
        ShowroomBasicInfo showroomBasicInfo = new ShowroomBasicInfo(carEntity.getShowroom().getId() , carEntity.getShowroom().getName());
        getCarResponsesDTO.setShowroom(showroomBasicInfo);

        return getCarResponsesDTO;
    }
    public Page<GetAllCarResponsesDTO> convertToDTO(Page<CarEntity> carEntities){

        return carEntities.map( carEntity -> {
          GetAllCarResponsesDTO getAllCarResponsesDTO = new GetAllCarResponsesDTO();
            getAllCarResponsesDTO.setId(carEntity.getId());
            getAllCarResponsesDTO.setModel(carEntity.getModel());
            getAllCarResponsesDTO.setMaker(carEntity.getMaker());
            getAllCarResponsesDTO.setPrice(carEntity.getPrice());
            getAllCarResponsesDTO.setModelYear(carEntity.getModelYear());
            getAllCarResponsesDTO.setVehicleIdentificationNumber(carEntity.getVehicleIdentificationNumber());

            ShowroomBasicInfo showroomBasicInfo = new ShowroomBasicInfo(carEntity.getShowroom().getId() , carEntity.getShowroom().getName());
            getAllCarResponsesDTO.setShowroomBasicInfo(showroomBasicInfo);
            return getAllCarResponsesDTO;
        });


        }

    }




