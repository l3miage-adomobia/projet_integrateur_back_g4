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
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final PanierRepository panierRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final EtapeRepository etapeRepository;
    private final PanierService panierService;
/*
    request: idfestival, nombre de places, List<idEtape,int(nombre de places)>,
    mail utilisateur ( correspond a une liste d’id d’etapes et les places prises pour chacune de ces étapes ).
    Le travail à faire au back end. recuperer ces informations pour creer une reservation et creer par la suite
    un panier. ( bien mettre en etat pas validé ).
 */
    @SneakyThrows
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ReservationDtoResponse ajouterResaAuPanier(String mailUtilisateur, Long idEtape, int nbPlacesReserve){
            Etape etape = etapeRepository.getEtapeByIdEtape(idEtape);
            if(etape == null){
               throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Etape inexistante" );
            }
            Utilisateur utilisateur = utilisateurRepository.getUtilisateurByEmail(mailUtilisateur);
            if(utilisateur == null){ //Si utilisateur n'existe pas
                utilisateur = new Utilisateur();
                utilisateur.setEmail(mailUtilisateur);
                utilisateur.setTypeUtilisateur("festivalier");
                utilisateurRepository.save(utilisateur);
            }
            Panier panier = panierService.getPanierActif(mailUtilisateur);
            Reservation reservation = new Reservation(nbPlacesReserve, etape, panier);
            reservationRepository.save(reservation);
            panier.getReservations().add(reservation);
            return new ReservationDtoResponse(reservation);
    }
}
