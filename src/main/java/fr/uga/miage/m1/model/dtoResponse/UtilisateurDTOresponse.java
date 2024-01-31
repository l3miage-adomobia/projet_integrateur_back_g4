package fr.uga.miage.m1.model.dtoResponse;


import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Utilisateur;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDTOresponse { //
    private Long idUtilisateur;
    private String nom;
    private String email;
    private String typeUtilisateur;
    private List<PanierDtoResponse> paniers;

    public UtilisateurDTOresponse(Utilisateur utilisateur){
        this.idUtilisateur = utilisateur.getIdUtilisateur();
        this.nom = utilisateur.getNom();
        this.email = utilisateur.getEmail();
        this.typeUtilisateur = utilisateur.getTypeUtilisateur();
        this.paniers = new ArrayList<PanierDtoResponse>();
        utilisateur.getPaniers().forEach(p-> this.paniers.add(new PanierDtoResponse(p)));
    }
}
