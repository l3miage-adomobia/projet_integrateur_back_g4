package fr.uga.miage.m1.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Domaine {
    @Id
    @NotNull
    @Size(max = 50)
    private String nomDomaine;

}
