package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Utilisateur;
import fr.uga.miage.m1.repository.PanierRepository;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanierService {

    private final PanierRepository panierRepository;
    private final UtilisateurRepository utilisateurRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public Panier getPanierActif(String mailUtilisateur){

        Panier panier;
        List<Panier> paniers = panierRepository.findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur);
        int nbPaniersNonValides = paniers.size();

        if(nbPaniersNonValides > 1){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error getting user cart, too many carts ");
        }

        if(nbPaniersNonValides == 1){ //L'utilisateur a un panier actif
            panier = paniers.get(0);
        }else { // L'utilisateur n'a pas de panier actif

            Utilisateur user = utilisateurRepository.getUtilisateurByEmail(mailUtilisateur);
            panier = new Panier();
            panier.setValide(false);
            panier.setFestivalier(user);
            panierRepository.save(panier);
        }
        return panier;
    }
}
