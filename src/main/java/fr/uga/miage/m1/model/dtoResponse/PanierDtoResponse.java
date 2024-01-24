package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Panier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDtoResponse {
    private Long idPanier;
    private Boolean valide;
    private List<ReservationDtoResponse> reservations;
    private Long festivalierId;

    public PanierDtoResponse(Panier panier){
        this.idPanier = panier.getIdPanier();
        this.valide = panier.getValide();
        panier.getReservations().forEach(r -> this.reservations.add(new ReservationDtoResponse(r)));
        this.festivalierId = panier.getFestivalier().getIdUtilisateur();
    }
}
