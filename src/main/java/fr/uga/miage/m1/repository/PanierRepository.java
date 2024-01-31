package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PanierRepository extends JpaRepository<Panier,Long> {


    @Query("SELECT count(*) FROM Panier p join Utilisateur u where u.email=?1 AND p.valide=false")
    int getNbPanierNonValide(String userMail);

    //@Query("SELECT p FROM Panier p  join Utilisateur u where u.email= :m and p.valide=false")
    List<Panier> findPanierByFestivalier_EmailAndValideFalse(@Param("m") String userMail);

}
