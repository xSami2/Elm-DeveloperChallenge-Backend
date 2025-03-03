package com.elm.developerChallenge.Mapper;

import com.elm.developerChallenge.DTO.Request.Showroom.SaveShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.GetAllShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.GetShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.SaveShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Request.Showroom.UpdateShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Respones.Showroom.UpdateShowroomResponsesDTO;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ShowroomMapper {

    private final ObjectMapper mapper;

    // Convert From DTO to Entity ( OverLoading Method )

    public ShowroomEntity convertToShowroomEntity(GetShowroomResponsesDTO getShowroomResponsesDTO) {
        return mapper.convertValue(getShowroomResponsesDTO, ShowroomEntity.class);
    }

    public ShowroomEntity convertToShowroomEntity(SaveShowroomRequestDTO saveShowroomRequestDTO) {
        return mapper.convertValue(saveShowroomRequestDTO, ShowroomEntity.class);
    }

    public ShowroomEntity convertToShowroomEntity(UpdateShowroomRequestDTO updateShowroomRequestDTO) {
        return mapper.convertValue(updateShowroomRequestDTO, ShowroomEntity.class);
    }


    // Convert From Entity to DTO

    public GetShowroomResponsesDTO convertToCarShowroomDTO(ShowroomEntity carShowroomEntity) {
        return mapper.convertValue(carShowroomEntity, GetShowroomResponsesDTO.class);
    }

    public List<GetShowroomResponsesDTO> convertToCarShowroomDTOList(List<ShowroomEntity> carShowroomEntityList) {
       return carShowroomEntityList.stream().map(
                carShowroomEntity    -> mapper.convertValue( carShowroomEntity , GetShowroomResponsesDTO.class)
        ).collect(Collectors.toList());
    }

    public SaveShowroomResponsesDTO convertToCreateShowroomResponsesDTO(ShowroomEntity showroomEntity){
        return mapper.convertValue(showroomEntity, SaveShowroomResponsesDTO.class);

    }

    public UpdateShowroomResponsesDTO convertToUpdateShowroomResponsesDTO(ShowroomEntity showroomEntity){
        return mapper.convertValue(showroomEntity, UpdateShowroomResponsesDTO.class);
    }

    public Page<GetAllShowroomResponsesDTO> convertToDTO(Page<ShowroomEntity> pageableAllShowroomEntity) {
       return pageableAllShowroomEntity.map( showroomEntity -> {
           return mapper.convertValue(showroomEntity ,GetAllShowroomResponsesDTO.class);
       });
    }




}
