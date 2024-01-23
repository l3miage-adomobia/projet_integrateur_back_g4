package fr.uga.miage.m1.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegionDTO {
    private Long regionId;
    private String nomRegion;
}
