package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Utilisateur;
import fr.uga.miage.m1.repository.FestivalRepository;
import fr.uga.miage.m1.repository.PanierRepository;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanierService {

    private final PanierRepository panierRepository;
    private final UtilisateurRepository utilisateurRepository;

    public Panier getPanierActif(String mailUtilisateur){
        //List<ReservationDtoResponse> r = new ArrayList<>();
        //reservationRepository.getReservationsPanierActif(mailFest).forEach(resa -> r.add(new ReservationDtoResponse(resa)));
        //return reservationRepository.getReservationsPanierActif(mailFest);
        int nbPaniersNonValides;
        nbPaniersNonValides=panierRepository.getNbPanierNonValide(mailUtilisateur);
        if(nbPaniersNonValides != 0 && nbPaniersNonValides != 1){
            // TODO error logic metier (toujours 1 ou 0 panier valide)
        }

        Panier panier = new Panier();
        if(nbPaniersNonValides == 1){
            List<Panier> paniers = panierRepository.getPaniersNonValides(mailUtilisateur);
            if(paniers.size()==1){
                panier = paniers.get(0); // panier d'où on extrait les information
            }
            else {
                // TODO error logic metier (toujours 1 ou 0 panier valide)
            }
        }else if (nbPaniersNonValides == 0) {  // si panier invalidé inexistant créer panier vide
            Utilisateur user = utilisateurRepository.getUtilisateurByEmail(mailUtilisateur);
            panier = new Panier();
            panier.setFestivalier(user);
            panier.setValide(false);
            panierRepository.save(panier);
        }

        return panier;
    }
}
