package com.elm.developerChallenge.Service.Command;


import com.elm.developerChallenge.DTO.API_Responses;
import com.elm.developerChallenge.DTO.Showroom.SaveShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.SaveShowroomResponsesDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomRequestDTO;
import com.elm.developerChallenge.DTO.Showroom.UpdateShowroomResponsesDTO;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.elm.developerChallenge.Mapper.ShowroomMapper;
import com.elm.developerChallenge.Repository.ShowroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ShowroomCommandServiceImpl {



    private final ShowroomRepository showroomRepository;
    private final ShowroomMapper showroomMapper;


    public ResponseEntity<API_Responses<SaveShowroomResponsesDTO>> saveCarShowroom(SaveShowroomRequestDTO saveShowroomRequestDTO) {
        String commercialRegistrationNumber = saveShowroomRequestDTO.getCommercialRegistrationNumber();

        Optional<ShowroomEntity> existingCommercialRegistrationNumber = showroomRepository
                .findShowroomEntityByCommercialRegistrationNumber(commercialRegistrationNumber);


        // Early Return if Commercial Registration Number is already taken
        if(existingCommercialRegistrationNumber.isPresent()){

            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    new API_Responses<>(
                            409,
                            "The Commercial Registration Number (CRN) you provided is already in use. Please enter a unique CRN for the showroom.",
                            null
                    )
            );

        }


        ShowroomEntity showroomEntity = showroomMapper.convertToShowroomEntity(saveShowroomRequestDTO);
        ShowroomEntity savedShowroomEntity = showroomRepository.save(showroomEntity);

        SaveShowroomResponsesDTO savedShowroomDTO = showroomMapper.convertToCreateShowroomResponsesDTO(savedShowroomEntity);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new API_Responses<>(201, "Showroom created successfully", savedShowroomDTO));



    }

    public ResponseEntity<API_Responses<UpdateShowroomResponsesDTO>> updateShowroom(UpdateShowroomRequestDTO updateShowroomRequestDTO){
        String showroomId = updateShowroomRequestDTO.getId();
        Optional<ShowroomEntity> optionalShowroomEntity = showroomRepository.findById(showroomId);

        // Early Return if showroom not exists
        if (optionalShowroomEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new API_Responses<>(
                            404,
                            "The showroom with the provided ID could not be found. Please verify if showroom is exists and try again",
                            null
                    )
            );
        }

        ShowroomEntity showroomEntity = showroomMapper.convertToShowroomEntity(updateShowroomRequestDTO);
        ShowroomEntity savedShowroomEntity = showroomRepository.save(showroomEntity);

        UpdateShowroomResponsesDTO savedShowroomDTO = showroomMapper.convertToUpdateShowroomResponsesDTO(savedShowroomEntity);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new API_Responses<>(200, "Showroom updated  successfully.", savedShowroomDTO));



    }
    public ResponseEntity<API_Responses<String>> deleteCarShowroom(String carShowroomId) {
        Optional<ShowroomEntity> optionalCarShowroomEntity  = showroomRepository.findById(carShowroomId);

        if (optionalCarShowroomEntity.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new API_Responses<>(404, "Could not found Car Showroom With ID : " + carShowroomId, null));
        }



        showroomRepository.deleteById(carShowroomId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(
                        new API_Responses<>(
                                200,
                                "Showroom with ID " + carShowroomId + " has been successfully deleted.",
                                null
                        )
                );



    }






}
