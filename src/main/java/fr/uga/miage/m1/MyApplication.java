package fr.uga.miage.m1;

import fr.uga.miage.m1.model.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;

@SpringBootApplication
public class MyApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        Reservation reservation = new Reservation() ;

    }
}
