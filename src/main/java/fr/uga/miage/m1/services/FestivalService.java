package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FestivalService {

    private final FestivalRepository festivalRepository;

    public List<FestivalDtoResponse> findFirst10Festivals(){
        List<Festival> f = festivalRepository.findFirst10Festivals();
        List<FestivalDtoResponse> festivalDtoResponses = new ArrayList<>();
        f.forEach(festival -> festivalDtoResponses.add(new FestivalDtoResponse(festival)));
        return festivalDtoResponses;
    }

    public List<FestivalDtoResponse> find10FestivalsByPage(int pageNumber){
        List<Festival> f = festivalRepository.find10FestivalsByPage(pageNumber);
        List<FestivalDtoResponse> festivalDtoResponses = new ArrayList<>();
        f.forEach(festival -> festivalDtoResponses.add(new FestivalDtoResponse(festival)));
        return festivalDtoResponses;
    }

    public void addPlacesToFestival(Long idFestival, int nombrePlacesAjouter) throws Exception {
        Festival festival = festivalRepository.findById(idFestival)
                .orElseThrow(() -> new Exception("Festival non trouvé"));

        festival.setNombrePass(festival.getNombrePass() + nombrePlacesAjouter);
        festivalRepository.save(festival);
    }


    public List<FestivalDtoResponse> findFestivalsByDateDebut(LocalDate dateDebut) {
        List<Festival> f = festivalRepository.getAllByDateDebut(dateDebut);
        List<FestivalDtoResponse> festivalDtoResponses = new ArrayList<>();
        f.forEach(festival -> festivalDtoResponses.add(new FestivalDtoResponse(festival)));
        return festivalDtoResponses;
    }

    public List<FestivalDtoResponse> findFestivalsByNomFestival(String partOfFestName) {
        String partOfFestNameLowerCase = partOfFestName.toLowerCase();
        List<Festival> f = festivalRepository.getAllByNomFestival(partOfFestNameLowerCase);
        List<FestivalDtoResponse> festivalDtoResponses = new ArrayList<>();
        f.forEach(festival -> festivalDtoResponses.add(new FestivalDtoResponse(festival)));
        return festivalDtoResponses;
    }


    public List<FestivalDtoResponse> getAllFestivalsByMultipleFilters(String partOfFestName, LocalDate date, Long insee, String sousdomaine) {
        String partOfFestNameLowerCase = (partOfFestName!=null) ? partOfFestName.toLowerCase() : null;
        String sousdomaineLowerCase = (sousdomaine!=null) ? sousdomaine.toLowerCase() : null;
        List<Festival> f = festivalRepository.getAllFestivalsByMultipleFilters(partOfFestNameLowerCase, date, insee, sousdomaineLowerCase);
        List<FestivalDtoResponse> festivalDtoResponses = new ArrayList<>();
        f.forEach(festival -> festivalDtoResponses.add(new FestivalDtoResponse(festival)));
        return festivalDtoResponses;
    }


}
