package fr.uga.miage.m1.model.dtoResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.Lieu;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import fr.uga.miage.m1.model.entities.SousDomaine;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FestivalDtoResponse {//

    private Long idFestival;
    private String nomFestival;
    private int tarif;
    private String siteWeb;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String lieuPrincipal;
    private int nombrePass;
    private LieuDTOresponse lieu;

    private String nomSousDomaine;
    private SousDomaineDTOresponse sousDomaine;

    public FestivalDtoResponse(Festival festival){
        this.idFestival = festival.getIdFestival();
        this.nomFestival = festival.getNomFestival();
        this.tarif = festival.getTarif();
        this.siteWeb = festival.getSiteWeb();
        this.dateDebut = festival.getDateFin();
        this.dateFin = festival.getDateFin();
        this.lieuPrincipal = festival.getLieuPrincipal();
        this.nombrePass = festival.getNombrePass();
        this.lieu = new LieuDTOresponse(festival.getLieu());
        this.sousDomaine = new SousDomaineDTOresponse(festival.getSousDomaine());
        this.nomSousDomaine = this.sousDomaine.getNomSousDomaine();
        //this.domaine = festival.getSousDomaine().getNomDomaine();
        //this.nomSousDomaine = festival.getSousDomaine().getNomSousDomaine();
    }
}
