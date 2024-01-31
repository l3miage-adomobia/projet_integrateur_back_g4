package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.ArretCovoiturage;
import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtapeDtoResponse { //

    private Long idEtape;
    private int tarif;
    private int duree;
    private LocalTime heureDepart;
    //private Long offreCovoiturageId;
    private ArretCovoiturageDtoResponse depart;
    private OffreCovoiturageDtoResponse offreCovoiturage;

    public EtapeDtoResponse(Etape etape){
        this.idEtape = etape.getIdEtape();
        this.tarif = etape.getTarif();
        this.duree = etape.getDuree();
        this.heureDepart = etape.getHeureDepart();
        this.depart = new ArretCovoiturageDtoResponse(etape.getDepart());
        this.offreCovoiturage = new OffreCovoiturageDtoResponse(etape.getOffreCovoiturage());
    }
}


