package fr.uga.miage.m1.model.dto;

import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Long idReservation;
    private int nbPlaces;
    private Long trajetId;
    private Long panierId;

    public ReservationDto(Reservation reservation){
        this.idReservation = reservation.getIdReservation();
        this.nbPlaces = reservation.getNbPlaces();
        this.trajetId = reservation.getTrajet().getIdEtape();
        this.panierId = reservation.getPanier().getIdPanier();
    }
}
