package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Etape;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtapeDtoResponse {

    private Long idEtape;
    private int nbPlaces;
    private String nomCovoitureur;
    private String modeleVoiture;
    private Double latitude;
    private Double longitude;
    private String nomCommune;
    private int tarif;
    private int duree;
    private LocalTime dateDepart;

    public EtapeDtoResponse(Etape etape){
        this.idEtape = etape.getIdEtape();
        this.nbPlaces = etape.getOffreCovoiturage().getNbPlacesOffertes();
        this.nomCovoitureur = etape.getOffreCovoiturage().getCovoitureur().getNom();
        this.modeleVoiture = etape.getOffreCovoiturage().getModeleVoiture();
        this.tarif = etape.getTarif();
        this.duree = etape.getDuree();
        this.dateDepart = etape.getHeureDepart();
        this.latitude = etape.getDepart().getLatitude();
        this.longitude = etape.getDepart().getLongitude();
        this.nomCommune = etape.getDepart().getLieu().getNomCommune();
    }

}
