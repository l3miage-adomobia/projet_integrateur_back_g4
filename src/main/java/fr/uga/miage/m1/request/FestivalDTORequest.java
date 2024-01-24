package fr.uga.miage.m1.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
@Schema(description = "Correspond à la requête permettant de créer une entité test")
public class FestivalDTORequest {
    @Schema(description = "correspond à l'Id du festival",example = "23")
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
}
