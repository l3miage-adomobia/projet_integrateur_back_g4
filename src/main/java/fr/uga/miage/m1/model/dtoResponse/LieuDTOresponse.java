package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Lieu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LieuDTOresponse {//
    private Long idLieu;
    private Long codeInsee;
    private Integer codePostal;
    private String nomCommune;
    private Double longitude;
    private Double latitude;
    private DepartementDTOresponse departement;

    public LieuDTOresponse(Lieu lieu){
        this.idLieu = lieu.getIdLieu();
        this.codeInsee = lieu.getCodeInsee();
        this.codePostal = lieu.getCodePostal();
        this.nomCommune = lieu.getNomCommune();
        this.longitude = lieu.getLongitude();
        this.latitude = lieu.getLatitude();
        this.departement = new DepartementDTOresponse(lieu.getDepartement());
    }
}
