package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FestivalRepository extends JpaRepository<Festival,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM (SELECT * FROM festival ORDER BY DATE_DEBUT) WHERE ROWNUM <= 10")
    List<Festival> findFirst10Festivals();

    List<Festival> getFestivalsByDateDebut(LocalDate dateDebut);
    List<Festival> getFestivalsByNomFestival(String nomFestival);
}
