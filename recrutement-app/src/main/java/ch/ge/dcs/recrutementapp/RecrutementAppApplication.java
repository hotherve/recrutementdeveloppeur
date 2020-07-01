package ch.ge.dcs.recrutementapp;

import ch.ge.dcs.recrutementapp.model.Salle;
import ch.ge.dcs.recrutementapp.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class RecrutementAppApplication {

    @Autowired
    private SalleRepository salleRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecrutementAppApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void remplissageEventSalle() {
        System.out.println("hello world, I have just started up");
        List<Salle> salles = salleRepository.findAll();
        salles.stream().forEach(salle -> System.out.println(salle));

    }

}
