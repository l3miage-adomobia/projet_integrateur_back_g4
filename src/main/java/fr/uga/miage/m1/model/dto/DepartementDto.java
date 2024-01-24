package fr.uga.miage.m1.model.dto;

import fr.uga.miage.m1.model.entities.Departement;
import fr.uga.miage.m1.model.entities.Region;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDto {
    private int noDepartement;
    private String nomDepartement;
    private String regionName;

    public DepartementDto(Departement departement){
        this.noDepartement = departement.getNoDepartement();
        this.nomDepartement = departement.getNomDepartement();
        this.regionName = departement.getRegion().getNomRegion();
    }
}
