package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Etape;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EtapeDtoResponse {

    private Long idEtape;
    private int tarif;
    private int duree;
    private Long departId;
    private Long offreCovoiturageId;

    public EtapeDtoResponse(Etape etape){
        this.idEtape = etape.getIdEtape();
        this.tarif = etape.getTarif();
        this.duree = etape.getDuree();
        this.departId = etape.getDepart().getIdArret();
        this.offreCovoiturageId = etape.getOffreCovoiturage().getIdOffreDeCovoiturage();
    }

}
