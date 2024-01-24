package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.Domaine;
import fr.uga.miage.m1.repository.DomaineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomaineService {

    private final DomaineRepository domaineRepository;

    public Domaine save(Domaine domaine){ return domaineRepository.save(domaine);}

    public List<Domaine> findAll(){ return domaineRepository.findAll();}

}

