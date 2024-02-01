package fr.uga.miage.m1.controllers;

import fr.uga.miage.m1.model.dtoRequest.OffreCovoiturageRequest;
import fr.uga.miage.m1.model.dtoResponse.EtapeDtoResponse;
import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.model.dtoResponse.OffreCovoiturageDtoResponse;
import fr.uga.miage.m1.services.OffreCovoiturageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@Tag(name ="Offre Covoiturage controller")
@RequestMapping("api/covoiturages")
public class OffreCovoiturageController {

    private final OffreCovoiturageService covoiturageService;

    public OffreCovoiturageController(OffreCovoiturageService covoiturageService) {
        this.covoiturageService = covoiturageService;
    }

/*
    @PostMapping
    public ResponseEntity<?> createCovoiturage(@RequestBody OffreCovoiturageRequest request) {
        try {
            covoiturageService.createCovoiturage(request);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
*/

    @GetMapping("/festival/{idFestival}")
    public ResponseEntity<List<EtapeDtoResponse>> getAllOffreCovoiturageByFestivalId(@PathVariable final Long idFestival){
        try{
            List<EtapeDtoResponse> offreCovoiturageList = covoiturageService.getAllOffreCovoiturageByFestivalId(idFestival);
            return ResponseEntity.ok().body(offreCovoiturageList);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error fetching covoiturages for festival: "  + e.getMessage(), e);
        }

    }




}
