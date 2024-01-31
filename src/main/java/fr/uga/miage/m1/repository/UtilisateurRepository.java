package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {

     @Query("SELECT u FROM Utilisateur u WHERE u.email = :e")
     Utilisateur getUtilisateurByEmail(@Param("e") String email);

}
