package fr.uga.miage.m1.controllers;

import fr.uga.miage.m1.model.dtoResponse.InfoReservationresponse;
import fr.uga.miage.m1.model.dtoResponse.ReservationDtoResponse;
import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.services.ReservationService;
import fr.uga.miage.m1.services.PanierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@Tag(name ="ReservationController controller")
@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    private final ReservationService reservationService;
    private final PanierService panierService;

    public ReservationController(ReservationService reservationService, PanierService panierService) {
        this.reservationService = reservationService;
        this.panierService = panierService;
    }

    @PostMapping("ajouter/mailFestivalier/{mailUtilisateur}/idEtape/{idEtape}/nbPlaces/{nbPlacesReserve}")
    public ResponseEntity<ReservationDtoResponse> ajouterResaAuPanier(
            @PathVariable String mailUtilisateur,
            @PathVariable Long idEtape,
            @PathVariable int nbPlacesReserve
    ) {
        try {
            Panier panier = panierService.getPanierActif(mailUtilisateur);
            ReservationDtoResponse response = reservationService.ajouterResaAuPanier(mailUtilisateur, idEtape, nbPlacesReserve, panier);
            return ResponseEntity.ok(response);

        } /*catch (PanierNotFoundException e) {
            // Handle PanierNotFoundException
            // You can log the exception or perform other error-handling actions
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Panier not found for email: " + mailUtilisateur, e);
        } catch (ReservationException e) {
            // Handle other ReservationExceptions
            // You can log the exception or perform other error-handling actions
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error adding reservation to the panier: " + e.getMessage(), e);
        } */catch (Exception e) {
            // Handle any other unexpected exceptions
            // You can log the exception or perform other error-handling actions
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error adding reservation to the panier: "  + e.getMessage(), e);
        }
    }


}
