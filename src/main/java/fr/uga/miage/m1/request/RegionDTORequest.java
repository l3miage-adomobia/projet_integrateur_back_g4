package fr.uga.miage.m1.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Schema(description = "Correspond à la requête permettant de créer une entité Reponse")
public class RegionDTORequest {
    @Schema(description = "correspond à l'Id de la region",example = "Auvergne")
    String nomRegion;
}
