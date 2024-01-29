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


    //@Query(value = "SELECT * FROM festival WHERE DATE_DEBUT >= :d", nativeQuery = true)
    List<Festival> getAllByDateDebut(@Param("d") LocalDate dateDebut);
    @Query(value = "SELECT * FROM Festival WHERE nom_festival LIKE %:pof%", nativeQuery = true)
    List<Festival> getAllByNomFestival(@Param("pof") String partOfFestName);



    @Query(value = "SELECT * " +
            "FROM festival f " +
            "join LIEU l ON f.fk_id_lieu=l.id_lieu " +
            "join SOUS_DOMAINE s ON f.fk_id_sous_domaine=s.id_sous_domaine " +
            "WHERE (:fn IS Null OR NOM_FESTIVAL = :fn) " +
            "AND (:d IS Null OR DATE_DEBUT = :d) " +
            "AND (:i IS Null OR l.code_insee = :i) " +
            "AND (:sd IS Null  OR s.nom_sous_domaine= :sd)", nativeQuery = true)
    List<Festival> getAllFestivalsByMultipleFilters(@Param("fn") String partOfFestName, @Param("d") LocalDate date, @Param("i") Long insee, @Param("sd") String sousdomaine);

    /*
    SELECT *
    FROM fetival f
    left join LIEU l ON f.fk_id_lieu=l.id_lieu
    left join SOUS_DOMAINE s ON l.fk_id_sous_domaine=s.id_sous_domaine
    WHERE (NOM_FESTIVAL = :fn OR :fn IS Null)
    AND (DATE_DEBUT = :d OR :d IS Null)
    AND (l.code_insee = :i OR :i IS Null)
    AND ( s.nom_sous_domaine= :sd OR :sd IS Null)
    */
}
