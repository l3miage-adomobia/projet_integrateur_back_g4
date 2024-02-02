package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.SousDomaine;
import fr.uga.miage.m1.repository.SousDomaineRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SousDomaineService {

    private final SousDomaineRepository sousDomaineRepository;

    @Transactional(readOnly = true)
    @SneakyThrows
    public List<SousDomaine> findAll(){ return sousDomaineRepository.findAll();}


}
