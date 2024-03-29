package fr.uga.miage.m1.controllers;

import fr.uga.miage.m1.model.dtoResponse.PanierDtoResponse;
import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.services.PanierService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Tag(name ="ReservationController controller")
@RestController
@RequestMapping("api/paniers")
public class PanierController {
    private final PanierService panierService;

    PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    @GetMapping("/mailFest/{mailFest}")
    PanierDtoResponse getPanierActif(@PathVariable String mailFest){
        return new PanierDtoResponse(panierService.getPanierActif(mailFest));
    }

}
