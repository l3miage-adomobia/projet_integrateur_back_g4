package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.repository.EtapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtapeService {
        private EtapeRepository etapeRepository;

        public Etape saveEtape(Etape etape) {
            return etapeRepository.save(etape);
        }

        public Etape getEtapeById(Long id) {
            return etapeRepository.findById(id).orElse(null);
        }

        public Iterable<Etape> getAllEtapes() {
            return etapeRepository.findAll();
        }

        public void deleteEtape(Long id) {
            etapeRepository.deleteById(id);
        }
}
