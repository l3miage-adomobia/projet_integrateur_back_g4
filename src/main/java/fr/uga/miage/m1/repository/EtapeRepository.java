package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Etape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EtapeRepository extends JpaRepository<Etape,Long> {
    @Query("SELECT e FROM Etape e WHERE e.idEtape=?1")
    Etape getEtapeByIdEtape(Long idEtape);

}
