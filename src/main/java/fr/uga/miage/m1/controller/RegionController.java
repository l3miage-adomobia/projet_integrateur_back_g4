package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.exception.technical.FestivalEntityNotFoundException;
import fr.uga.miage.m1.model.dto.RegionDTO;
import fr.uga.miage.m1.model.entities.Region;
import fr.uga.miage.m1.repository.RegionRepository;
import fr.uga.miage.m1.request.RegionDTORequest;
import fr.uga.miage.m1.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = "Your API Tag", description = "Description of your API")
public class RegionController {

    private final RegionService regionService;
    private final RegionRepository regionRepository;

    @Operation(description = "Création d'une entité Region")
    @ApiResponse(responseCode = "201", description = "L'entité Region a bien été créée.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/regions")
    public void createEntityRegion(@RequestBody Region region) {
        regionService.createRegion(region);
    }
    @Operation(description = "Création d'une entité Region")
    @ApiResponse(responseCode = "201", description = "L'entité Region a bien été créée.")
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/regions/{regionId}")
    public Region getEntityRegion(@PathVariable Long regionId) {
        try {
            return regionService.getRegion(regionId);
        }catch (FestivalEntityNotFoundException e){
            throw new RuntimeException("Region not found");
        }
    }
}
