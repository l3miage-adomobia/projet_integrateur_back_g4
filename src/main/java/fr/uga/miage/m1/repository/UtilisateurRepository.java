package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

     Utilisateur getUtilisateurByEmail(String email);

}
