package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Festival;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FestivalDtoResponse {

    private Long idFestival;
    private String nomFestival;
    private int tarif;
    private String siteWeb;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String lieuPrincipal;
    private int nombrePass;
    private Long lieuCodeInsee;
    private String nomSousDomaine;
    private String domaine;

    public FestivalDtoResponse(Festival festival){
        this.idFestival = festival.getIdFestival();
        this.nomFestival = festival.getNomFestival();
        this.tarif = festival.getTarif();
        this.siteWeb = festival.getSiteWeb();
        this.dateDebut = festival.getDateFin();
        this.dateFin = festival.getDateFin();
        this.lieuPrincipal = festival.getLieuPrincipal();
        this.domaine = festival.getSousDomaine().getNomDomaine();
        this.nomSousDomaine = festival.getSousDomaine().getNomSousDomaine();
    }
}
