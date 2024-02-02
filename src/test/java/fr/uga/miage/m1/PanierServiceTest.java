package fr.uga.miage.m1;

import fr.uga.miage.m1.model.entities.Panier;
import fr.uga.miage.m1.model.entities.Utilisateur;
import fr.uga.miage.m1.repository.PanierRepository;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import fr.uga.miage.m1.services.PanierService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PanierServiceTest {

    @Mock
    private PanierRepository panierRepository;

    @Mock
    private UtilisateurRepository utilisateurRepository;

    @InjectMocks
    private PanierService panierService;

    @Test
    void testGetPanierActifWithExistingPanier() {
        String mailUtilisateur = "user@example.com";

        // Mock data
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(mailUtilisateur);

        Panier existingPanier = new Panier();
        existingPanier.setValide(false);
        existingPanier.setFestivalier(utilisateur);

        List<Panier> paniers = new ArrayList<>();
        paniers.add(existingPanier);

        // Mock repository behavior
        when(panierRepository.findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur)).thenReturn(paniers);

        // Call the service method
        Panier resultPanier = panierService.getPanierActif(mailUtilisateur);

        // Assertions
        assertEquals(existingPanier, resultPanier);

        // Verify that the repository method was called
        Mockito.verify(panierRepository, Mockito.times(1)).findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur);
    }

    @Test
    void testGetPanierActifWithoutExistingPanier() {
        String mailUtilisateur = "user@example.com";

        // Mock data
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(mailUtilisateur);

        // Mock repository behavior
        when(panierRepository.findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur)).thenReturn(new ArrayList<>());
        when(utilisateurRepository.getUtilisateurByEmail(mailUtilisateur)).thenReturn(utilisateur);

        // Call the service method
        Panier resultPanier = panierService.getPanierActif(mailUtilisateur);

        // Assertions
        assertEquals(mailUtilisateur, resultPanier.getFestivalier().getEmail());
        assertEquals(false, resultPanier.getValide());

        // Verify that the repository methods were called
        Mockito.verify(panierRepository, Mockito.times(1)).findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur);
        Mockito.verify(panierRepository, Mockito.times(1)).save(resultPanier);
    }

    @Test
    void testGetPanierActifWithMultiplePaniers() {
        String mailUtilisateur = "user@example.com";

        // Mock data
        List<Panier> paniers = new ArrayList<>();
        paniers.add(new Panier());
        paniers.add(new Panier());

        // Mock repository behavior
        when(panierRepository.findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur)).thenReturn(paniers);

        // Call the service method and expect an exception
        assertThrows(ResponseStatusException.class, () -> panierService.getPanierActif(mailUtilisateur));

        // Verify that the repository method was called
        Mockito.verify(panierRepository, Mockito.times(1)).findPanierByFestivalier_EmailAndValideFalse(mailUtilisateur);
    }
}
