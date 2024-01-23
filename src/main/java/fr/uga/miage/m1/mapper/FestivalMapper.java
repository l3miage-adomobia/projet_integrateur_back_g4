package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.request.FestivalDTORequest;
import fr.uga.miage.m1.response.FestivalDTOresponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper( componentModel = "spring" )
public interface FestivalMapper {


    FestivalDTOresponse toDto(Festival Festival);

    Festival toEntity(FestivalDTORequest request);
}
