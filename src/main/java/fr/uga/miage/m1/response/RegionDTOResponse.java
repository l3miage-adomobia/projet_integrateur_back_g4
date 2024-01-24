package fr.uga.miage.m1.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class RegionDTOResponse {
    Long regionId;
    String nomRegion;
}
