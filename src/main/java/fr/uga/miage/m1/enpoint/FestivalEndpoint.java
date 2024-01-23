package fr.uga.miage.m1.enpoint;
import fr.uga.miage.m1.exception.technical.FestivalEntityNotFoundException;
import fr.uga.miage.m1.request.FestivalDTORequest;
import fr.uga.miage.m1.response.FestivalDTOresponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@Tag(name = "FestiCar tag")
@CrossOrigin
@RestController
@RequestMapping("api/festivals")
public interface FestivalEndpoint {


    // GET
    @Operation(description = "Récupérer le DTO de l'entité Festival qui a pour idFestival celui passé en paramètre")
    @ApiResponse(responseCode = "200", description = "Renvoie le DTO de l'entité Festival demandée", content = @Content(schema = @Schema(implementation = FestivalDTOresponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    //@ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée", content = @Content(schema = @Schema(implementation = MiahootNotFoundErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{festivalId}")
    FestivalDTOresponse getEntityFestival(@PathVariable Long festivalId) throws FestivalEntityNotFoundException;


    /*
    @GetMapping("{userId}")
    List<Miahoot> getEntityMiahoot(@PathVariable String userId);

*/
    // POST
    @Operation(description = "Création d'une entité Festival")
    @ApiResponse(responseCode = "201", description = "L'entité Festival a bien été créée.")
    //@Error400Custom
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createEntityFestival(@Valid @RequestBody FestivalDTORequest request);


/*
    // PATCH
    @Operation(description = "Mise à jour d'une entité Miahoot")
    @ApiResponse(responseCode = "202", description = "L'entité à bien été mis à jour")
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée", content = @Content(schema = @Schema(implementation = MiahootNotFoundErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @Error400Custom
    @ResponseStatus(HttpStatus.ACCEPTED)

    @PatchMapping("{userId}/{nom}")
    void updateMiahootEntity(@PathVariable final String userId, @PathVariable final String nom,
                             @RequestBody final Miahoot miahoot);

    // DELETE
    @Operation(description = "Suppression d'une entité Miahoot en bd")
    @ApiResponse(responseCode = "200", description = "si isInError est à false alors 'Hello word' est renvoyé")
    @ApiResponse(responseCode = "404", description = "Renvoie une erreur 404 si l'entité n'est pas trouvée", content = @Content(schema = @Schema(implementation = MiahootNotFoundErrorResponse.class), mediaType = MediaType.APPLICATION_JSON_VALUE))
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{userId}/{nom}")
    void deleteMiahootEntity(@PathVariable String userId, @PathVariable String nom);

    @DeleteMapping("{userId}")
    void deleteMiahootEntity(@PathVariable String userId);


     */
}