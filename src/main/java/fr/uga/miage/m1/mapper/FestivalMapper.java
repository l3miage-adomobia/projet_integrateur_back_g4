package fr.uga.miage.m1.mapper;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.request.FestivalDTORequest;
import fr.uga.miage.m1.response.FestivalDTOresponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper( componentModel = "spring" )
public interface FestivalMapper {
    FestivalMapper INSTANCE = Mappers.getMapper(FestivalMapper.class);

    @Mappings({
            @Mapping(target = "dateDebut", ignore = true),
            @Mapping(target = "dateFin", ignore = true) // You can add more if needed
    })
    Festival toEntity(FestivalDTORequest request);
    FestivalDTOresponse toDto(Festival Festival);


}
/*
* @Schema(description = "correspond à l'Id du festival",example = "23")
    Long festivalId;

    @Schema(description = "correspond au nom du festival",example = "¡ Viva Villa !")
    String nomFestival;

    @Schema(description = "correspond au prix du festival",example = "20")
    int tarif;

    @Schema(description = "correspond au site du festival",example = "www.alartlibre.com")
    String siteWeb;

    @Schema(description = "correspond au lieu principal du festival",example = "POITIERS")
    String lieuPrincipal;

    @Schema(description = "correspond au nombre de pass du festival",example = "200")
    Integer nombrePass;
* */