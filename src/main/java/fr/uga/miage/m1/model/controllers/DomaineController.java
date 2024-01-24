package fr.uga.miage.m1.model.controllers;

import fr.uga.miage.m1.model.entities.Domaine;
import fr.uga.miage.m1.services.DomaineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domaines")
public class DomaineController {

    private final DomaineService service;

    public DomaineController(DomaineService domaineService){
        this.service = domaineService;
    }

    @GetMapping()
    public ResponseEntity<List<Domaine>> getAllDomaine(){
        List<Domaine> domaineList = service.findAll();
        return ResponseEntity.ok().body(domaineList);
    }
}
