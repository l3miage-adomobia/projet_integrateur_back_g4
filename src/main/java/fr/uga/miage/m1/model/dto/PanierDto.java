package fr.uga.miage.m1.model.dto;

import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Reservation;
import fr.uga.miage.m1.model.entities.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDto {
    private Long idPanier;
    private Boolean valide;
    private List<ReservationDto> reservations;
    private Long festivalierId;

    public PanierDto(Panier panier){
        this.idPanier = panier.getIdPanier();
        this.valide = panier.getValide();
        panier.getReservations().forEach(r -> this.reservations.add(new ReservationDto(r)));
        this.festivalierId = panier.getFestivalier().getIdUtilisateur();
    }
}
