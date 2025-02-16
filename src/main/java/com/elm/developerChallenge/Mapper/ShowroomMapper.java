package com.elm.developerChallenge.Mapper;

import com.elm.developerChallenge.DTO.Showroom.SaveShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.SaveShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.ShowroomDTO;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ShowroomMapper {

    private final ObjectMapper mapper;

    // Convert From DTO to Entity ( OverLoading Method )

    public ShowroomEntity convertToShowroomEntity(ShowroomDTO showroomDTO) {
        return mapper.convertValue(showroomDTO, ShowroomEntity.class);
    }

    public ShowroomEntity convertToShowroomEntity(SaveShowroomRequestDTO saveShowroomRequestDTO) {
        return mapper.convertValue(saveShowroomRequestDTO, ShowroomEntity.class);
    }

    public ShowroomEntity convertToShowroomEntity(UpdateShowroomRequestDTO updateShowroomRequestDTO) {
        return mapper.convertValue(updateShowroomRequestDTO, ShowroomEntity.class);
    }


    // Convert From Entity to DTO

    public ShowroomDTO convertToCarShowroomDTO(ShowroomEntity carShowroomEntity) {
        return mapper.convertValue(carShowroomEntity, ShowroomDTO.class);
    }

    public List<ShowroomDTO> convertToCarShowroomDTOList(List<ShowroomEntity> carShowroomEntityList) {
       return carShowroomEntityList.stream().map(
                carShowroomEntity    -> mapper.convertValue( carShowroomEntity , ShowroomDTO.class)
        ).collect(Collectors.toList());
    }

    public SaveShowroomResponsesDTO convertToCreateShowroomResponsesDTO(ShowroomEntity showroomEntity){
        return mapper.convertValue(showroomEntity, SaveShowroomResponsesDTO.class);

    }

    public UpdateShowroomResponsesDTO convertToUpdateShowroomResponsesDTO(ShowroomEntity showroomEntity){
        return mapper.convertValue(showroomEntity, UpdateShowroomResponsesDTO.class);
    }



}
