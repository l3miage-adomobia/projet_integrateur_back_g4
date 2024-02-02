package fr.uga.miage.m1;

import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;
import fr.uga.miage.m1.services.FestivalService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FestivalServiceTest {

    @Mock
    private FestivalRepository festivalRepository;

    @InjectMocks
    private FestivalService festivalService;

    @Test
    void testFindFirst10Festivals() {
        List<Festival> festivals = Arrays.asList(new Festival(), new Festival());
        when(festivalRepository.findFirst10Festivals()).thenReturn(festivals);

        List<FestivalDtoResponse> result = festivalService.findFirst10Festivals();

        assertEquals(festivals.size(), result.size());
        verify(festivalRepository, Mockito.times(1)).findFirst10Festivals();
    }

    @Test
    void testFind10FestivalsByPage() {
        int pageNumber = 1;
        List<Festival> festivals = Arrays.asList(new Festival(), new Festival());
        when(festivalRepository.find10FestivalsByPage(pageNumber)).thenReturn(festivals);

        List<FestivalDtoResponse> result = festivalService.find10FestivalsByPage(pageNumber);

        assertEquals(festivals.size(), result.size());
        verify(festivalRepository, Mockito.times(1)).find10FestivalsByPage(pageNumber);
    }

    @Test
    void testAddPlacesToFestival() throws Exception {
        Long idFestival = 1L;
        int nombrePlacesAjouter = 10;
        Festival festival = new Festival();
        when(festivalRepository.findById(idFestival)).thenReturn(Optional.of(festival));

        festivalService.addPlacesToFestival(idFestival, nombrePlacesAjouter);

        assertEquals(festival.getNombrePass(), 10);
        verify(festivalRepository, Mockito.times(1)).save(festival);
    }

    @Test
    void testFindFestivalsByDateDebut() {
        LocalDate dateDebut = LocalDate.now();
        List<Festival> festivals = Arrays.asList(new Festival(), new Festival());
        when(festivalRepository.getAllByDateDebut(dateDebut)).thenReturn(festivals);

        List<FestivalDtoResponse> result = festivalService.findFestivalsByDateDebut(dateDebut);

        assertEquals(festivals.size(), result.size());
        verify(festivalRepository, Mockito.times(1)).getAllByDateDebut(dateDebut);
    }

    @Test
    void testFindFestivalsByNomFestival() {
        String partOfFestName = "test";
        List<Festival> festivals = Arrays.asList(new Festival(), new Festival());
        when(festivalRepository.getAllByNomFestival(anyString())).thenReturn(festivals);

        List<FestivalDtoResponse> result = festivalService.findFestivalsByNomFestival(partOfFestName);

        assertEquals(festivals.size(), result.size());
        verify(festivalRepository, Mockito.times(1)).getAllByNomFestival(anyString());
    }

    @Test
    void testGetAllFestivalsByMultipleFilters() {
        String partOfFestName = "test";
        LocalDate date = LocalDate.now();
        String nomCommuneFest = "commune";
        String sousdomaine = "domain";
        String nomCommuneArret = "arret";
        int page = 1;

        List<Festival> festivals = Arrays.asList(new Festival(), new Festival());
        when(festivalRepository.getAllFestivalsByMultipleFilters(
                anyString(), any(LocalDate.class), anyString(), anyString(), anyString(), anyInt()))
                .thenReturn(festivals);

        List<FestivalDtoResponse> result = festivalService.getAllFestivalsByMultipleFilters(
                partOfFestName, date, nomCommuneFest, sousdomaine, nomCommuneArret, page);

        assertEquals(festivals.size(), result.size());
        verify(festivalRepository, Mockito.times(1)).getAllFestivalsByMultipleFilters(
                anyString(), any(LocalDate.class), anyString(), anyString(), anyString(), anyInt());
    }
}
