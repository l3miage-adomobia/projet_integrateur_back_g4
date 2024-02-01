package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Panier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PanierRepository extends JpaRepository<Panier,Long> {



    List<Panier> findPanierByFestivalier_EmailAndValideFalse(@Param("m") String userMail);

}
