package com.elm.developerChallenge.Assembler;
import org.springframework.hateoas.IanaLinkRelations;

import com.elm.developerChallenge.Controller.Command.ShowroomCommandController;
import com.elm.developerChallenge.Controller.Query.ShowroomQueryController;
import com.elm.developerChallenge.DTO.Respones.Showroom.GetAllShowroomResponsesDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class ShowroomModelAssembler implements RepresentationModelAssembler<GetAllShowroomResponsesDTO , EntityModel<GetAllShowroomResponsesDTO>> {

    @Override
    public EntityModel<GetAllShowroomResponsesDTO> toModel(GetAllShowroomResponsesDTO entity) {
        return
                EntityModel.of(entity,
                        linkTo(
                                methodOn(
                                        ShowroomQueryController.class
                                ).getShowroomById(
                                        entity.getId()
                                )
                        )
                                .withSelfRel()
//                        linkTo(
//                               methodOn(
//                                       ShowroomCommandController.class
//                               ).deleteShowroom(
//                                       entity.getId()
//                               )
//                        ).withRel("Delete")

                );
    }
}
