package ch.ge.dcs.recrutementapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principale de lancement de spring boot
 */

@SpringBootApplication
public class RecrutementAppApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecrutementAppApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(RecrutementAppApplication.class, args);
    }

}
