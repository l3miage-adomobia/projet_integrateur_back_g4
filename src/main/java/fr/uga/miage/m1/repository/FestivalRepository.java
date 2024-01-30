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
    @Query(value = "SELECT * FROM Festival WHERE LOWER(nom_festival) LIKE %:pof%", nativeQuery = true)
    List<Festival> getAllByNomFestival(@Param("pof") String partOfFestName);



    @Query(value =
            "SELECT * FROM (" +
                    "" +
            "SELECT DISTINCT f.* " +
                    "FROM festival f " +
                    "join LIEU l ON f.fk_id_lieu=l.id_lieu " +
                    "join SOUS_DOMAINE s ON f.fk_id_sous_domaine=s.id_sous_domaine " +
                    "join OFFRE_COVOITURAGE oc ON f.id_festival=oc.fk_id_festival " +
                    "join ETAPE e ON oc.id_offre_de_covoiturage=e.fk_offre " +
                    "join ARRET_COVOITURAGE ac ON e.fk_depart=ac.id_arret " +
                    "join LIEU lc ON ac.fk_id_lieu=lc.id_lieu " +
                    "WHERE (:fn IS Null OR LOWER(NOM_FESTIVAL) LIKE %:fn%) " +
                    "AND (:d IS Null OR DATE_DEBUT = :d) " +
                    "AND (:ncf IS Null OR LOWER(l.nom_commune) LIKE %:ncf%) " +
                    "AND (:sd IS Null  OR LOWER(s.nom_sous_domaine) LIKE %:sd%) " +
                    "AND (:nc IS Null OR LOWER(lc.nom_commune) LIKE %:nc%) " +
                    ") OFFSET 10*(:p-1) ROWS FETCH FIRST 10 ROWS ONLY"
            , nativeQuery = true)
    List<Festival> getAllFestivalsByMultipleFilters(@Param("fn") String partOfFestName, @Param("d") LocalDate date, @Param("ncf") String nomCommuneFest, @Param("sd") String sousdomaine, @Param("nc") String nomCommuneArr, @Param("p") int page);
}
