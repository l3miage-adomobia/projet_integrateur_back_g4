package fr.uga.miage.m1.service;

import fr.uga.miage.m1.exception.technical.FestivalEntityNotFoundException;
import fr.uga.miage.m1.mapper.FestivalMapper;
import fr.uga.miage.m1.mapper.RegionMapper;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.Region;
import fr.uga.miage.m1.repository.FestivalRepository;
import fr.uga.miage.m1.repository.RegionRepository;
import fr.uga.miage.m1.request.FestivalDTORequest;
import fr.uga.miage.m1.request.RegionDTORequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionMapper regionMapper;
    private final RegionRepository regionRepository;

    public void createRegion(final Region region) {
        regionRepository.save(region);
    }

    public Region getRegion(final Long regionId) throws FestivalEntityNotFoundException{
        return regionRepository.findById(regionId)
                .orElseThrow(() -> new FestivalEntityNotFoundException(
                        String.format("Aucune entité n'a été trouvée pour userId [%s]", regionId),
                        regionId));
    }
}
