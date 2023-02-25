package dev.alexanghel.jpaquerybyexample;

import dev.alexanghel.jpaquerybyexample.repository.PassengerRepository;
import dev.alexanghel.jpaquerybyexample.model.Passenger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final PassengerRepository passengerRepository;

    public Application(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testPassengerQueryExample();
    }

    private void testPassengerQueryExample() {
        Passenger jill = new Passenger("Jill", "Smith", 50);
        Passenger eve = new Passenger("Eve", "Jackson", 95);
        Passenger fredi = new Passenger("Fredi", "Bloggs", 22);
        Passenger kan = new Passenger("Kan", "Buga", 23);
        Passenger siya = new Passenger("Siya", "Kolisi", 85);
        Passenger ricki = new Passenger("Ricki", "Bobbie", 36);

        passengerRepository.save(jill);
        passengerRepository.save(eve);
        passengerRepository.save(fredi);
        passengerRepository.save(kan);
        passengerRepository.save(siya);
        passengerRepository.save(ricki);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.endsWith().ignoreCase())
                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase())
                .withIgnorePaths("firstName")
                .withIgnorePaths("seatNumber");

        Example<Passenger> example = Example.of(new Passenger(null, "b", 8888888),
                exampleMatcher);

        List<Passenger> passengers = passengerRepository.findAll(example);

        passengers.forEach(System.out::println);
    }
}
