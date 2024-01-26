package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreCovoiturageRepository extends JpaRepository<OffreCovoiturage,Long> {

/*
    @Query(value = "", nativeQuery = true)
    List<OffreCovoiturage> getOffreCovoiturageByFestivalId(@Param("idF") Long idFestival);
*/

}
