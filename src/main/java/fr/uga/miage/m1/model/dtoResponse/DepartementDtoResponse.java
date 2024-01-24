package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Departement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDtoResponse {
    private int noDepartement;
    private String nomDepartement;
    private String regionName;

    public DepartementDtoResponse(Departement departement){
        this.noDepartement = departement.getNoDepartement();
        this.nomDepartement = departement.getNomDepartement();
        this.regionName = departement.getRegion().getNomRegion();
    }
}
