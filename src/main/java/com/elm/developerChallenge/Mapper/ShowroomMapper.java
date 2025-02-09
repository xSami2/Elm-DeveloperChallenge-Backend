package com.elm.developerChallenge.Mapper;

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

    public ShowroomEntity convertToCarShowroomEntity(ShowroomDTO showroomDTO) {
        return mapper.convertValue(showroomDTO, ShowroomEntity.class);
    }

    public ShowroomDTO convertToCarShowroomDTO(ShowroomEntity carShowroomEntity) {
        return mapper.convertValue(carShowroomEntity, ShowroomDTO.class);
    }

    public List<ShowroomDTO> convertToCarShowroomDTOList(List<ShowroomEntity> carShowroomEntityList) {
       return carShowroomEntityList.stream().map(
                carShowroomEntity    -> mapper.convertValue( carShowroomEntity , ShowroomDTO.class)
        ).collect(Collectors.toList());
    }


}
