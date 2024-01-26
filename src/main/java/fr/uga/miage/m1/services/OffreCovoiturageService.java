package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.dtoRequest.OffreCovoiturageRequest;
import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.model.dtoResponse.OffreCovoiturageDtoResponse;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import fr.uga.miage.m1.repository.FestivalRepository;
import fr.uga.miage.m1.repository.OffreCovoiturageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OffreCovoiturageService {

        private OffreCovoiturageRepository offreCovoiturageRepository;
        private FestivalRepository festivalRepository;

        // Ajouter d'autres repositories si nécessaire, par exemple, pour Etape

        public void createCovoiturage(OffreCovoiturageRequest request) throws Exception {
            Festival festival = festivalRepository.findById(request.getIdFestival())
                    .orElseThrow(() -> new Exception("Festival non trouvé"));

            OffreCovoiturage offreCovoiturage = new OffreCovoiturage();
            offreCovoiturage.setNbPlacesOffertes(request.getNbPlacesOffertes());
            offreCovoiturage.setModeleVoiture(request.getModeleVoiture());
            offreCovoiturage.setFestival(festival);

            // Creer l'etape à partir des étapes request qui seront envoyés
            // pour cela creer les étapes dabord

            // ajouter le covoiturage finale a la liste de covoiturages du festival
            festival.getCovoiturages().add(offreCovoiturage);

            offreCovoiturageRepository.save(offreCovoiturage);

        }

        /*
        public List<OffreCovoiturageDtoResponse> getOffreCovoiturageByFestivalId(Long idFestival) {
            List<OffreCovoiturage> c = offreCovoiturageRepository.getOffreCovoiturageByFestivalId(idFestival);
            List<OffreCovoiturageDtoResponse> offreCovoiturageDtoResponse = new ArrayList<>();
            c.forEach(covoiturage -> offreCovoiturageDtoResponse.add(new OffreCovoiturageDtoResponse(covoiturage)));
            return offreCovoiturageDtoResponse;
        }
        */
}
