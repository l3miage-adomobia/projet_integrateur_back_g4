package fr.uga.miage.m1.model.dto;

import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import fr.uga.miage.m1.model.entities.Utilisateur;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OffreCovoiturageDto {

    private Long idOffreDeCovoiturage;
    private int nbPlacesOffertes;
    private String modeleVoiture;
    private List<EtapeDto> etapes;
    private Long festivalId;
    private Long covoitureurId;

    public OffreCovoiturageDto(OffreCovoiturage offreCovoiturage){
        this.idOffreDeCovoiturage = offreCovoiturage.getIdOffreDeCovoiturage();
        this.nbPlacesOffertes = offreCovoiturage.getNbPlacesOffertes();
        this.modeleVoiture = offreCovoiturage.getModeleVoiture();
        offreCovoiturage.getEtapes().forEach(e-> this.etapes.add(new EtapeDto(e)));
        this.covoitureurId = offreCovoiturage.getCovoitureur().getIdUtilisateur();
    }

}
