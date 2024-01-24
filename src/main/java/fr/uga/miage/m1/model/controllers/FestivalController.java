package fr.uga.miage.m1.model.controllers;

import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.model.entities.Domaine;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.services.FestivalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@Tag(name ="Festival controller")
@RestController
@RequestMapping("/api/festival")
public class FestivalController {
     private final FestivalService festivalService;

     public FestivalController(FestivalService s){
          this.festivalService = s;
     }
     @GetMapping()
     public ResponseEntity<List<FestivalDtoResponse>> getAllDomaine(){
          List<FestivalDtoResponse> domaineList = festivalService.findAll();
          return ResponseEntity.ok().body(domaineList);
     }
}
