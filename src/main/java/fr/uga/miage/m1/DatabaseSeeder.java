package fr.uga.miage.m1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final TestEntityRepository repository;

    public DatabaseSeeder(TestEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        TestEntity testEntity = new TestEntity();
        testEntity.setName("Exemple");
        repository.save(testEntity);
    }
}
