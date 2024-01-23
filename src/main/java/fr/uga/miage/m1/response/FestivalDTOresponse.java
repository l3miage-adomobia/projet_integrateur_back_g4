package fr.uga.miage.m1.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@Schema(description = "correspond au DTO de l'entité Festival")
public class FestivalDTOresponse {

    @Schema(description = "correspond à l'Id du festival",example = "23")
    Long festivalId;

    @Schema(description = "correspond au nom du festival",example = "¡ Viva Villa !")
    String nomFestival;

    @Schema(description = "correspond au prix du festival",example = "20")
    int tarif;

    @Schema(description = "correspond au site du festival",example = "www.alartlibre.com")
    String siteWeb;

    @Schema(description = "correspond à la date du début du festival",example = "01/12/23")
    LocalDate dateDebut;

    @Schema(description = "correspond à la date de fin du festival",example = "09/12/23")
    LocalDate dateFin;

    @Schema(description = "correspond au lieu principal du festival",example = "POITIERS")
    String lieuPrincipal;

    @Schema(description = "correspond au nombre de pass du festival",example = "200")
    Integer nombrePass;



}
