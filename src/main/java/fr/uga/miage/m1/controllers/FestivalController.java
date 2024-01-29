package fr.uga.miage.m1.controllers;

import fr.uga.miage.m1.model.dtoRequest.FestivalDtoRequest;
import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.services.FestivalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@Tag(name ="Festival controller")
@RestController
@RequestMapping("api/festivals")
public class FestivalController {
     private final FestivalService festivalService;

     public FestivalController(FestivalService s){
          this.festivalService = s;
     }

     @GetMapping()
     public ResponseEntity<List<FestivalDtoResponse>> findFirst10Festivals(){
          List<FestivalDtoResponse> domaineList = festivalService.findFirst10Festivals();
          return ResponseEntity.ok().body(domaineList);
     }

     @GetMapping("/page/{pageNumber}")
     public ResponseEntity<List<FestivalDtoResponse>> find10FestivalsByPage(@PathVariable final int pageNumber){
          List<FestivalDtoResponse> domaineList = festivalService.find10FestivalsByPage(pageNumber);
          return ResponseEntity.ok().body(domaineList);
     }

     @PutMapping("/addPlaces")
     public ResponseEntity<?> addPlacesToFestival(@RequestBody FestivalDtoRequest request) {
          try {
               festivalService.addPlacesToFestival(request.getIdFestival(), request.getNombrePlacesAjouter());
               return ResponseEntity.ok().build();
          } catch (Exception e) {
               // Gestion des exceptions
               return ResponseEntity.badRequest().body(e.getMessage());
          }
     }


     //get tous les festivals avec une date de début superieur ou égal à “dateDebut”
     @GetMapping("/filtre/date/{dateDebut}")
     public ResponseEntity<List<FestivalDtoResponse>> getFestivalsByDateDebut(@PathVariable final LocalDate dateDebut){
          List<FestivalDtoResponse> festivalList = festivalService.findFestivalsByDateDebut(dateDebut);
          return ResponseEntity.ok().body(festivalList);
     }

     @GetMapping("/filtre/nom/{partOfFestName}")
     public ResponseEntity<List<FestivalDtoResponse>> getFestivalsByDateDebut(@PathVariable final String partOfFestName){
          List<FestivalDtoResponse> festivalList = festivalService.findFestivalsByNomFestival(partOfFestName);
          return ResponseEntity.ok().body(festivalList);
     }




     @GetMapping("/filtres")
     public ResponseEntity<List<FestivalDtoResponse>> getAllFestivalsByMultipleFilters(@RequestParam(required = false) final String partOfFestName,@RequestParam(required = false) final LocalDate date,@RequestParam(required = false) final Long insee, @RequestParam(required = false) final String sousdomaine){
          List<FestivalDtoResponse> festivalList = festivalService.getAllFestivalsByMultipleFilters(partOfFestName, date, insee, sousdomaine);
          return ResponseEntity.ok().body(festivalList);
     }

}
