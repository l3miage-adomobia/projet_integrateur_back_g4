package fr.uga.miage.m1.model.dto;

import fr.uga.miage.m1.model.entities.ArretCovoiturage;
import fr.uga.miage.m1.model.entities.Lieu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArretCovoiturageDto {

    private Long idArret;
    private String nomLieu;
    private String adresseLieu;
    private Double longitude;
    private Double latitude;
    private Long lieuCodeInsee;

    public ArretCovoiturageDto(ArretCovoiturage arretCovoiturage){
        this.idArret = arretCovoiturage.getIdArret();
        this.nomLieu = arretCovoiturage.getNomLieu();
        this.adresseLieu = arretCovoiturage.getAdresseLieu();
        this.longitude = arretCovoiturage.getLongitude();
        this.latitude = arretCovoiturage.getLatitude();
        this.lieuCodeInsee = arretCovoiturage.getLieu().getCodeInsee();
    }
}
