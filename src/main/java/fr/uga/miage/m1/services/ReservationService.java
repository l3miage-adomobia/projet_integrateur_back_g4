package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.dtoResponse.ReservationDtoResponse;
import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Reservation;
import fr.uga.miage.m1.model.entities.Utilisateur;
import fr.uga.miage.m1.repository.EtapeRepository;
import fr.uga.miage.m1.repository.PanierRepository;
import fr.uga.miage.m1.repository.ReservationRepository;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final PanierRepository panierRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final EtapeRepository etapeRepository;
/*
    request: idfestival, nombre de places, List<idEtape,int(nombre de places)>,
    mail utilisateur ( correspond a une liste d’id d’etapes et les places prises pour chacune de ces étapes ).
    Le travail à faire au back end. recuperer ces informations pour creer une reservation et creer par la suite
    un panier. ( bien mettre en etat pas validé ).
 */
    public ReservationDtoResponse ajouterResaAuPanier(String mailUtilisateur, Long idEtape, int nbPlacesReserve, Panier panier){


        Utilisateur user = utilisateurRepository.getUtilisateurByEmail(mailUtilisateur);
        Etape etape = etapeRepository.getEtapeByIdEtape(idEtape);
        Reservation reservation = new Reservation(nbPlacesReserve, etape, panier);

        panierRepository.save(panier);
        reservationRepository.save(reservation);

        return new ReservationDtoResponse(reservation);

    }


}
