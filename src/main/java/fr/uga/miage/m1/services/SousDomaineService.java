package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.Domaine;
import fr.uga.miage.m1.model.entities.SousDomaine;
import fr.uga.miage.m1.repository.DomaineRepository;
import fr.uga.miage.m1.repository.SousDomaineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SousDomaineService {

    private final SousDomaineRepository sousDomaineRepository;

    public List<SousDomaine> findAll(){ return sousDomaineRepository.findAll();}


}
