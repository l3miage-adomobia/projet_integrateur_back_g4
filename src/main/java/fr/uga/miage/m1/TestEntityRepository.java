package fr.uga.miage.m1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
    // Vous pouvez ajouter d'autres méthodes de requête ici si nécessaire.
}

