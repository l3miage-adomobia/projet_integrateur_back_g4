package fr.uga.miage.m1.service;
import fr.uga.miage.m1.exception.technical.FestivalEntityNotFoundException;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.repository.FestivalRepository;
import fr.uga.miage.m1.request.FestivalDTORequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FestivalService {
    private final FestivalMapper festivalMapper;
    private final FestivalRepository festivalRepository;

    public Festival getFestival(final Long festivalId) throws FestivalEntityNotFoundException{
        return festivalRepository.findByFestivalId(festivalId)
                .orElseThrow(() -> new FestivalEntityNotFoundException(
                        String.format("Aucune entité n'a été trouvée pour festivalId [%s]", festivalId),
                        festivalId));
    }

    public void createFestival(final FestivalDTORequest festivalDTORequest){
        Festival festival = FestivalMapper.INSTANCE.toEntity(festivalDTORequest);
        festivalRepository.save(festival);
    }
}
