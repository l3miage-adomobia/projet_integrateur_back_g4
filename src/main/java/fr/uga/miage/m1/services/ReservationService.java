package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.dtoResponse.InfoReservationresponse;
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
    public ReservationDtoResponse ajouterResaAuPanier(String mailUtilisateur, Long idEtape, int nbPlacesReserve){

        int nbPaniersNonValides;
        nbPaniersNonValides=panierRepository.getNbPanierNonValide(mailUtilisateur);
        if(nbPaniersNonValides != 0 && nbPaniersNonValides != 1){
            // TODO error logic metier (toujours 1 ou 0 panier valide)
        }

        Panier panier=null;

        if(nbPaniersNonValides == 1){
            List<Panier> paniers = panierRepository.getPaniersNonValides(mailUtilisateur);
            if(paniers.size()==1){
                panier = paniers.get(0);
            }
            else {
                // TODO error logic metier (toujours 1 ou 0 panier valide)
            }

        }else if (nbPaniersNonValides == 0) {
            Utilisateur user = utilisateurRepository.getUtilisateurByEmail(mailUtilisateur);
            panier = new Panier(user,false);
            panierRepository.save(panier);
        }

        Etape etape = etapeRepository.getEtapeByIdEtape(idEtape);
        Reservation reservation = new Reservation(nbPlacesReserve, etape, panier);
        reservationRepository.save(reservation);

        return new ReservationDtoResponse(reservation);

    }


}
