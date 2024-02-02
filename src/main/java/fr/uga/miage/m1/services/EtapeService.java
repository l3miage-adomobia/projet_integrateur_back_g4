package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.Etape;
import fr.uga.miage.m1.repository.EtapeRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EtapeService {
        private EtapeRepository etapeRepository;

        @SneakyThrows
        public Etape saveEtape(Etape etape) {
            return etapeRepository.save(etape);
        }

        @Transactional(readOnly = true)
        public Etape getEtapeById(Long id) {
            return etapeRepository.findById(id).orElse(null);
        }

        @Transactional(readOnly = true)
        @SneakyThrows
        public Iterable<Etape> getAllEtapes() {
            return etapeRepository.findAll();
        }

        @SneakyThrows
        public void deleteEtape(Long id) {
            etapeRepository.deleteById(id);
        }
}
