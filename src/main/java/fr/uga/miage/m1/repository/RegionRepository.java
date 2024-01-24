package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Region;
import fr.uga.miage.m1.model.entities.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository  extends JpaRepository<Region, Long> {
    Optional<Region> findById(Long regionId);
}
