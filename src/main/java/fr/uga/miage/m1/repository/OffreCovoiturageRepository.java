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


    @Query(value = "SELECT * FROM offre_covoiturage WHERE FK_ID_FESTIVAL = :f ", nativeQuery = true)
    List<OffreCovoiturage> getAllOffreCovoiturageByIdFestival(@Param("f") Long idFestival);


}
