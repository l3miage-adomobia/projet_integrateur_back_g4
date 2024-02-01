package fr.uga.miage.m1.repository;

import fr.uga.miage.m1.model.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

/*
SELECT
    f.NOM_FESTIVAL AS NOM_FESTIVAL,
    f.DATE_DEBUT AS DATE_DEBUT,
    f.DATE_FIN AS DATE_FIN,
    f.LIEU_PRINCIPAL AS LIEU_PRINCIPAL,
    f.TARIF AS TARIF_FESTIVAL,
    sd.NOM_DOMAINE AS DOMAINE,
    sd.NOM_SOUS_DOMAINE AS SOUS_DOMAINE,
    uc.NOM AS COVOITUREUR,
    r.NB_PLACES AS NB_PLACES_CHOISIES,
    oc.MODELE_VOITURE AS MODELE_VOITURE,
    e.HEURE_DEPART AS DATE_DEPART,
    e.FK_DEPART AS FK_LIEU_DEPART,
    e.TARIF AS TARIF_ETAPE
FROM RESERVATION r
JOIN ETAPE e ON r.FK_ID_ETAPE = e.ID_ETAPE
JOIN OFFRE_COVOITURAGE oc ON e.FK_OFFRE = oc.ID_OFFRE_DE_COVOITURAGE
JOIN PANIER p ON r.FK_ID_PANIER = p.ID_PANIER
JOIN FESTIVAL f ON oc.FK_ID_FESTIVAL = f.ID_FESTIVAL
JOIN SOUS_DOMAINE sd ON f.FK_ID_SOUS_DOMAINE = sd.ID_SOUS_DOMAINE
JOIN UTILISATEUR uf ON p.FK_ID_FESTIVALIER = u.ID_UTILISATEUR
JOIN UTILISATEUR uc ON oc.FK_ID_UTILISATEUR = uc.ID_UTILISATEUR
WHERE uf.EMAIL = '' AND  p.VALIDE= 1


@Query(value = "SELECT " +
            "f.NOM_FESTIVAL AS NOM_FESTIVAL, f.DATE_DEBUT AS DATE_DEBUT, f.DATE_FIN AS DATE_FIN, " +
            "f.LIEU_PRINCIPAL AS LIEU_PRINCIPAL, f.TARIF AS TARIF_FESTIVAL, sd.NOM_DOMAINE AS DOMAINE, " +
            "sd.NOM_SOUS_DOMAINE AS SOUS_DOMAINE, uc.NOM AS COVOITUREUR, r.NB_PLACES AS NB_PLACES_CHOISIES, " +
            "oc.MODELE_VOITURE AS MODELE_VOITURE, e.HEURE_DEPART AS DATE_DEPART, e.FK_DEPART AS FK_LIEU_DEPART, " +
            "e.TARIF AS TARIF_ETAPE " +
            "FROM RESERVATION r " +
            "JOIN ETAPE e ON r.FK_ID_ETAPE = e.ID_ETAPE " +
            "JOIN OFFRE_COVOITURAGE oc ON e.FK_OFFRE = oc.ID_OFFRE_DE_COVOITURAGE " +
            "JOIN PANIER p ON r.FK_ID_PANIER = p.ID_PANIER " +
            "JOIN FESTIVAL f ON oc.FK_ID_FESTIVAL = f.ID_FESTIVAL " +
            "JOIN SOUS_DOMAINE sd ON f.FK_ID_SOUS_DOMAINE = sd.ID_SOUS_DOMAINE " +
            "JOIN UTILISATEUR uf ON p.FK_ID_FESTIVALIER = uf.ID_UTILISATEUR " +
            "JOIN UTILISATEUR uc ON oc.FK_ID_UTILISATEUR = uc.ID_UTILISATEUR " +
            "WHERE uf.EMAIL = :m AND  p.VALIDE= 1"
            , nativeQuery = true)

@Query(value = "SELECT " +
            "f.NOM_FESTIVAL, f.DATE_DEBUT, f.DATE_FIN , " +
            "f.LIEU_PRINCIPAL , f.TARIF, sd.NOM_DOMAINE, " +
            "sd.NOM_SOUS_DOMAINE, uc.NOM, r.NB_PLACES, " +
            "oc.MODELE_VOITURE, e.HEURE_DEPART, e.FK_DEPART, " +
            "e.TARIF " +
            "FROM RESERVATION r " +
            "JOIN ETAPE e ON r.FK_ID_ETAPE = e.ID_ETAPE " +
            "JOIN OFFRE_COVOITURAGE oc ON e.FK_OFFRE = oc.ID_OFFRE_DE_COVOITURAGE " +
            "JOIN PANIER p ON r.FK_ID_PANIER = p.ID_PANIER " +
            "JOIN FESTIVAL f ON oc.FK_ID_FESTIVAL = f.ID_FESTIVAL " +
            "JOIN SOUS_DOMAINE sd ON f.FK_ID_SOUS_DOMAINE = sd.ID_SOUS_DOMAINE " +
            "JOIN UTILISATEUR uf ON p.FK_ID_FESTIVALIER = uf.ID_UTILISATEUR " +
            "JOIN UTILISATEUR uc ON oc.FK_ID_UTILISATEUR = uc.ID_UTILISATEUR " +
            "WHERE uf.EMAIL = :m AND  p.VALIDE= 1"
            , nativeQuery = true)
    List<InfoReservationresponse> getReservationsPanierActif(@Param("m") String mailFest);
*/





}
