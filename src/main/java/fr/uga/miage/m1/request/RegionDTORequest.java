package fr.uga.miage.m1.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RegionDTORequest {
    Long regionId;
    String nomRegion;
}
