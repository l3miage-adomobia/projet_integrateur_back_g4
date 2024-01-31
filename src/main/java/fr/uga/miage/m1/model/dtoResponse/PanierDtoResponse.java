package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Reservation;
import fr.uga.miage.m1.model.entities.Utilisateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDtoResponse { //
    private Long idPanier;
    private Boolean valide;
    private List<ReservationDtoResponse> reservations;
    //private Long festivalierId;

    public PanierDtoResponse(Panier panier){
        this.idPanier = panier.getIdPanier();
        this.valide = panier.getValide();
        this.reservations= new ArrayList<ReservationDtoResponse>();
        panier.getReservations().forEach(r -> this.reservations.add(new ReservationDtoResponse(r)));
        //this.festivalierId = panier.getFestivalier().getIdUtilisateur();
    }
}

