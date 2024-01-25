package fr.uga.miage.m1.controllers;

import fr.uga.miage.m1.model.dtoRequest.OffreCovoiturageRequest;
import fr.uga.miage.m1.services.OffreCovoiturageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Tag(name ="Offre Covoiturage controller")
@RequestMapping("/Offrescovoiturages")
public class OffreCovoiturageController {

    private final OffreCovoiturageService covoiturageService;

    public OffreCovoiturageController(OffreCovoiturageService covoiturageService) {
        this.covoiturageService = covoiturageService;
    }


    @PostMapping
    public ResponseEntity<?> createCovoiturage(@RequestBody OffreCovoiturageRequest request) {
        try {
            covoiturageService.createCovoiturage(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
