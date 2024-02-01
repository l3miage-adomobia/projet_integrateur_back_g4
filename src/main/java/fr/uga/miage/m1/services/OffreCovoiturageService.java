package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.dtoRequest.OffreCovoiturageRequest;
import fr.uga.miage.m1.model.dtoResponse.EtapeDtoResponse;
import fr.uga.miage.m1.model.dtoResponse.FestivalDtoResponse;
import fr.uga.miage.m1.model.dtoResponse.OffreCovoiturageDtoResponse;
import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.model.entities.Festival;
import fr.uga.miage.m1.model.entities.OffreCovoiturage;
import fr.uga.miage.m1.repository.FestivalRepository;
import fr.uga.miage.m1.repository.OffreCovoiturageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OffreCovoiturageService {

        private OffreCovoiturageRepository offreCovoiturageRepository;

        OffreCovoiturageService(OffreCovoiturageRepository offreCovoiturageRepository){
            this.offreCovoiturageRepository=offreCovoiturageRepository;
        }

//        private FestivalRepository festivalRepository;

        // Ajouter d'autres repositories si nécessaire, par exemple, pour Etape
/*
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
*/
        public List<EtapeDtoResponse> getAllOffreCovoiturageByFestivalId(Long idFestival) {

            List<EtapeDtoResponse> etapeCovoiturageDtoList = new ArrayList<EtapeDtoResponse>();
            List<OffreCovoiturage> offreCovoituragesList = offreCovoiturageRepository.getAllOffreCovoiturageByIdFestival(idFestival);

            List<Etape> etapes = new ArrayList<Etape>();

            offreCovoituragesList.forEach(offre ->
                    etapes.add(offre.getEtapes().get(0))
            );

            etapes.forEach(etape ->
                    etapeCovoiturageDtoList.add(new EtapeDtoResponse(etape))
            );


            return etapeCovoiturageDtoList;
        }

}
