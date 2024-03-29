package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.ArretCovoiturage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArretCovoiturageDtoResponse {

    private Long idArret;
    private String nomLieu;
    private String adresseLieu;
    private Double longitude;
    private Double latitude;
    private String typeArret;
    private Long lieuCodeInsee;

    public ArretCovoiturageDtoResponse(ArretCovoiturage arretCovoiturage){
        this.idArret = arretCovoiturage.getIdArret();
        this.nomLieu = arretCovoiturage.getNomLieu();
        this.adresseLieu = arretCovoiturage.getAdresseLieu();
        this.longitude = arretCovoiturage.getLongitude();
        this.latitude = arretCovoiturage.getLatitude();
        this.typeArret = arretCovoiturage.getTypeArret();
        this.lieuCodeInsee = arretCovoiturage.getLieu().getCodeInsee();
    }
}
