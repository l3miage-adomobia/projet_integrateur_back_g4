package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreCovoiturageDtoResponse {

    private Long idOffreDeCovoiturage;
    private int nbPlacesOffertes;
    private String modeleVoiture;
    private List<EtapeDtoResponse> etapes;
    private Long festivalId;
    //private Long covoitureurId;

    public OffreCovoiturageDtoResponse(OffreCovoiturage offreCovoiturage){
        this.idOffreDeCovoiturage = offreCovoiturage.getIdOffreDeCovoiturage();
        this.nbPlacesOffertes = offreCovoiturage.getNbPlacesOffertes();
        this.modeleVoiture = offreCovoiturage.getModeleVoiture();
        this.etapes = new ArrayList<>();
        offreCovoiturage.getEtapes().forEach(e-> this.etapes.add(new EtapeDtoResponse(e)));
      //  this.covoitureurId = offreCovoiturage.getCovoitureur().getIdUtilisateur();
    }

}
