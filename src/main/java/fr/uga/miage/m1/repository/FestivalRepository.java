package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FestivalRepository extends JpaRepository<Festival,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM (SELECT * FROM festival ORDER BY date_debut) WHERE ROWNUM <= 10")
    List<Festival> findFirst10Festivals();

    @Query(value = "SELECT * FROM (SELECT f.*, ROWNUM rnum FROM (SELECT * FROM festival ORDER BY date_debut) f WHERE ROWNUM <= :p*10) WHERE rnum > (:p-1)*10", nativeQuery = true)
    List<Festival> find10FestivalsByPage(@Param("p")  int pageNumber );


    List<Festival> getFestivalsByDateDebut(LocalDate dateDebut);
    List<Festival> getFestivalsByNomFestival(String nomFestival);
}
