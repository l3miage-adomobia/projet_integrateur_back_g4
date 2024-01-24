package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreCovoiturageRepository extends JpaRepository<OffreCovoiturage,Long> {
}
