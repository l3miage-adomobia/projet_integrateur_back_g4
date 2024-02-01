package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDtoResponse { //
    private Long idReservation;
    private String nomFestival;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String lieuPrincipal;
    private int nbPlaces;
    private EtapeDtoResponse trajet;
    //private Long panierId;


    public ReservationDtoResponse(Reservation reservation){
        this.idReservation = reservation.getIdReservation();
        this.nomFestival = reservation.getTrajet().getOffreCovoiturage().getFestival().getNomFestival();
        this.dateDebut = reservation.getTrajet().getOffreCovoiturage().getFestival().getDateDebut();
        this.dateFin = reservation.getTrajet().getOffreCovoiturage().getFestival().getDateFin();
        this.lieuPrincipal = reservation.getTrajet().getOffreCovoiturage().getFestival().getLieuPrincipal();
        this.nbPlaces = reservation.getNbPlaces();
        //this.panierId = reservation.getPanier().getIdPanier();
        this.trajet = new EtapeDtoResponse(reservation.getTrajet());

    }
}
