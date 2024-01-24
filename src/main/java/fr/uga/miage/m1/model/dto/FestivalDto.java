package fr.uga.miage.m1.model.dto;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.Lieu;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import fr.uga.miage.m1.model.entities.SousDomaine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FestivalDto {

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
    private List<OffreCovoiturageDto> offreCovoiturageDtos = new ArrayList<>();

    public FestivalDto(Festival festival){
        this.idFestival = festival.getIdFestival();
        this.nomFestival = festival.getNomFestival();
        this.tarif = festival.getTarif();
        this.siteWeb = festival.getSiteWeb();
        this.dateDebut = festival.getDateFin();
        this.dateFin = festival.getDateFin();
        this.lieuPrincipal = festival.getLieuPrincipal();
        this.lieuCodeInsee = festival.getLieu().getCodeInsee();
        this.nomSousDomaine = festival.getSousDomaine().getNomSousDomaine();
        festival.getCovoiturages().forEach(covoit -> this.offreCovoiturageDtos.add(new OffreCovoiturageDto(covoit)));
    }
}
