package fr.uga.miage.m1;

import fr.uga.miage.m1.model.dtoResponse.EtapeDtoResponse;
import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import fr.uga.miage.m1.repository.OffreCovoiturageRepository;
import fr.uga.miage.m1.services.OffreCovoiturageService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OffreCovoiturageServiceTest {

    @Mock
    private OffreCovoiturageRepository offreCovoiturageRepository;

    @InjectMocks
    private OffreCovoiturageService offreCovoiturageService;

    @Test
    void testGetAllOffreCovoiturageByFestivalId() {
        Long idFestival = 1L;

        // Mock data
        List<OffreCovoiturage> offreCovoituragesList = new ArrayList<>();
        OffreCovoiturage offreCovoiturage1 = new OffreCovoiturage();
        offreCovoiturage1.setIdOffreDeCovoiturage(1L);
        offreCovoiturage1.setModeleVoiture("Car1");

        Etape etape1 = new Etape();
        etape1.setIdEtape(1L);
        etape1.setTarif(20);

        offreCovoiturage1.getEtapes().add(etape1);

        OffreCovoiturage offreCovoiturage2 = new OffreCovoiturage();
        offreCovoiturage2.setIdOffreDeCovoiturage(2L);
        offreCovoiturage2.setModeleVoiture("Car2");

        Etape etape2 = new Etape();
        etape2.setIdEtape(2L);
        etape2.setTarif(25);

        offreCovoiturage2.getEtapes().add(etape2);

        offreCovoituragesList.add(offreCovoiturage1);
        offreCovoituragesList.add(offreCovoiturage2);

        // Mock repository behavior
        when(offreCovoiturageRepository.getAllOffreCovoiturageByIdFestival(idFestival)).thenReturn(offreCovoituragesList);

        // Call the service method
        List<EtapeDtoResponse> result = offreCovoiturageService.getAllOffreCovoiturageByFestivalId(idFestival);

        // Assertions
        assertEquals(offreCovoituragesList.size(), result.size());
        assertEquals(offreCovoituragesList.get(0).getEtapes().get(0).getTarif(), result.get(0).getTarif());
        assertEquals(offreCovoituragesList.get(1).getEtapes().get(0).getTarif(), result.get(1).getTarif());

        // Verify that the repository method was called
        Mockito.verify(offreCovoiturageRepository, Mockito.times(1)).getAllOffreCovoiturageByIdFestival(idFestival);
    }
}
