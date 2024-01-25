package fr.uga.miage.m1.model.dtoRequest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreCovoiturageRequest {
    private int nbPlacesOffertes;
    private String modeleVoiture;
    private Long idFestival; // Id du festival associé à l'offre de covoiturage
    private List<Long> etapesIds;
}
