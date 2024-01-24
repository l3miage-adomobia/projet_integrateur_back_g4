package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FestivalService {

    private final FestivalRepository festivalRepository;

    public List<FestivalDtoResponse> findAll(){
        List<Festival> f = festivalRepository.findAll();
        List<FestivalDtoResponse> festivalDtoResponses = new ArrayList<>();
        f.forEach(festival -> festivalDtoResponses.add(new FestivalDtoResponse(festival)));
        return festivalDtoResponses;
    }

}
