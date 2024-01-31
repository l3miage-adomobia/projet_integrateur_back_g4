package fr.uga.miage.m1.model.dtoResponse;

import fr.uga.miage.m1.model.entities.Departement;
import fr.uga.miage.m1.model.entities.Region;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartementDTOresponse {
    private long idDepartement;
    private int noDepartement;
    private String nomDepartement;
    private RegionDTOresponse region;

    public DepartementDTOresponse(Departement departement){
        this.idDepartement = departement.getIdDepartement();
        this.noDepartement = departement.getNoDepartement();
        this.nomDepartement = departement.getNomDepartement();
        this.region = new RegionDTOresponse(departement.getRegion().getNomRegion());
    }
}

