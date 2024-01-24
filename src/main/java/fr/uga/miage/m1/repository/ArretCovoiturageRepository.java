package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.ArretCovoiturage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArretCovoiturageRepository extends JpaRepository<ArretCovoiturage, Long> {
}

