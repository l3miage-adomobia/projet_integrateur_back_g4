package fr.uga.miage.m1.controllers;

import fr.uga.miage.m1.model.entities.SousDomaine;
import fr.uga.miage.m1.services.SousDomaineService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@Tag(name ="Sous Domaine controller")
@RestController
@RequestMapping("/api/sousDomaine")
public class SousDomaineController {

    private final SousDomaineService sousDomaineService;

    public SousDomaineController(SousDomaineService s){
        this.sousDomaineService = s;
    }
    @GetMapping()
    public ResponseEntity<List<SousDomaine>> getAllDomaine(){
        List<SousDomaine> sousDomaines = sousDomaineService.findAll();
        return ResponseEntity.ok().body(sousDomaines);
    }
}
