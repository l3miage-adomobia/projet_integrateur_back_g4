package fr.uga.miage.m1.model.dtoResponse;


import fr.uga.miage.m1.model.entities.SousDomaine;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SousDomaineDTOresponse {
    private Long idSousDomaine;
    private String nomSousDomaine;
    private String  nomDomaine;

    public SousDomaineDTOresponse(SousDomaine sousDomaine){
        this.idSousDomaine = sousDomaine.getIdSousDomaine();
        this.nomSousDomaine = sousDomaine.getNomSousDomaine();
        this.nomDomaine = sousDomaine.getNomDomaine();
    }
}

