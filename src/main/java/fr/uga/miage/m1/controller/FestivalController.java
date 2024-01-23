package fr.uga.miage.m1.controller;

import fr.uga.miage.m1.enpoint.FestivalEndpoint;
import fr.uga.miage.m1.exception.technical.FestivalEntityNotFoundException;
import fr.uga.miage.m1.request.FestivalDTORequest;
import fr.uga.miage.m1.response.FestivalDTOresponse;
import fr.uga.miage.m1.service.FestivalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FestivalController implements FestivalEndpoint {

    private final FestivalService festivalService;
    @Override
    public FestivalDTOresponse getEntityFestival(Long festivalId) throws FestivalEntityNotFoundException {
        festivalService.getFestival(festivalId);
        return null;
    }

    @Override
    public void createEntityFestival(FestivalDTORequest request) {
        festivalService.createFestival(request);
    }
}
