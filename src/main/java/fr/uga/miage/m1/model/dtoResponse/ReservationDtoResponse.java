package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDtoResponse {
    private Long idReservation;
    private int nbPlaces;
    private Long trajetId;
    private Long panierId;

    public ReservationDtoResponse(Reservation reservation){
        this.idReservation = reservation.getIdReservation();
        this.nbPlaces = reservation.getNbPlaces();
        this.trajetId = reservation.getTrajet().getIdEtape();
        this.panierId = reservation.getPanier().getIdPanier();
    }
}
