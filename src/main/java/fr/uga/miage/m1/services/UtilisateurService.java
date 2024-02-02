package fr.uga.miage.m1.services;

import fr.uga.miage.m1.model.entities.Utilisateur;
import fr.uga.miage.m1.repository.UtilisateurRepository;
import jdk.jshell.execution.Util;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;

    @SneakyThrows
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Transactional(readOnly = true)
    @SneakyThrows
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @SneakyThrows
    public Iterable<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @SneakyThrows
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @SneakyThrows
    public Utilisateur getUtilisateurByEmail(String mailUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.getUtilisateurByEmail(mailUtilisateur);
        return utilisateur;
    }
}
