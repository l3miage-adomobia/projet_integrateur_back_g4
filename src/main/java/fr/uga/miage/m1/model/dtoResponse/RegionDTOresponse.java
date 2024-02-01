package fr.uga.miage.m1.model.dtoResponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.plaf.synth.Region;

@Data
@NoArgsConstructor
public class RegionDTOresponse {
    private String nomRegion;

    public RegionDTOresponse( String nomRegion){
        this.nomRegion = nomRegion;
    }
}

