package fr.uga.miage.m1;

import fr.uga.miage.m1.model.entities.Region;
import fr.uga.miage.m1.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
