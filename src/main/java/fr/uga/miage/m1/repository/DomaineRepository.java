package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Domaine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomaineRepository extends JpaRepository<Domaine,String> {

}
