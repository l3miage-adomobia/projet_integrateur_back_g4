package fr.uga.miage.m1.controllers;

import fr.uga.miage.m1.model.dtoResponse.InfoReservationresponse;
import fr.uga.miage.m1.model.dtoResponse.ReservationDtoResponse;
import fr.uga.miage.m1.services.ReservationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name ="ReservationController controller")
@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /*
    @PostMapping("ajouter/mailFestivalier/{mailUtilisateur}/idEtape/{idEtape}/nbPlaces/{nbPlacesReserve}")
    ReservationDtoResponse ajouterResaAuPanier(@PathVariable String mailUtilisateur, @PathVariable Long idEtape, @PathVariable int nbPlacesReserve){
        return reservationService.ajouterResaAuPanier(mailUtilisateur, idEtape, nbPlacesReserve);
    }
*/


}
