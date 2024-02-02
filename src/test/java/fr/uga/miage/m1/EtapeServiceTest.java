package fr.uga.miage.m1;
import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.repository.EtapeRepository;
import fr.uga.miage.m1.services.EtapeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EtapeServiceTest {

    @Mock
    private EtapeRepository etapeRepository;

    @InjectMocks
    private EtapeService etapeService;

    @Test
    void testSaveEtape() {
        Etape etapeToSave = new Etape();
        when(etapeRepository.save(any(Etape.class))).thenReturn(etapeToSave);

        Etape savedEtape = etapeService.saveEtape(new Etape());

        assertEquals(etapeToSave, savedEtape);
        verify(etapeRepository, Mockito.times(1)).save(any(Etape.class));
    }

    @Test
    void testGetEtapeById() {
        Long id = 1L;
        Etape etape = new Etape();
        when(etapeRepository.findById(id)).thenReturn(Optional.of(etape));

        Etape resultEtape = etapeService.getEtapeById(id);

        assertEquals(etape, resultEtape);
        verify(etapeRepository, Mockito.times(1)).findById(id);
    }

    @Test
    void testGetAllEtapes() {
        List<Etape> etapes = Arrays.asList(new Etape(), new Etape());
        when(etapeRepository.findAll()).thenReturn(etapes);

        Iterable<Etape> resultEtapes = etapeService.getAllEtapes();

        assertEquals(etapes, resultEtapes);
        verify(etapeRepository, Mockito.times(1)).findAll();
    }

    @Test
    void testDeleteEtape() {
        Long id = 1L;

        etapeService.deleteEtape(id);

        verify(etapeRepository, Mockito.times(1)).deleteById(id);
    }
}
