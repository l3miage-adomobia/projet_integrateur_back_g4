package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.request.FestivalDTORequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
    Optional<Festival> findByFestivalId(final Long festivalId);

}
