package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.dtoResponse.PanierDtoResponse;
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

    public PanierDtoResponse getPanierActif(String mailUtilisateur){
        //List<ReservationDtoResponse> r = new ArrayList<>();
        //reservationRepository.getReservationsPanierActif(mailFest).forEach(resa -> r.add(new ReservationDtoResponse(resa)));
        //return reservationRepository.getReservationsPanierActif(mailFest);
        int nbPaniersNonValides;
        List<Panier> paniers = panierRepository.findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur);
        nbPaniersNonValides= paniers.size();
        if(nbPaniersNonValides != 0 && nbPaniersNonValides != 1){
            // TODO error logic metier (toujours 1 ou 0 panier valide)
        }

        Panier panier = new Panier();
        if(nbPaniersNonValides == 1){
                panier = paniers.get(0);
        }else if (nbPaniersNonValides == 0) {
            Utilisateur user = utilisateurRepository.getUtilisateurByEmail(mailUtilisateur);
            panier = new Panier();
            panier.setFestivalier(user);
            panier.setValide(false);
            panierRepository.save(panier);
        }

        return new PanierDtoResponse(panier);
    }
}
