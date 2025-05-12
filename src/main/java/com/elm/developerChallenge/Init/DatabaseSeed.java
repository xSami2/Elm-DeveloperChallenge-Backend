package com.elm.developerChallenge.Init;

import com.elm.developerChallenge.Entity.CarEntity;
import com.elm.developerChallenge.Entity.ShowroomEntity;
import com.elm.developerChallenge.Repository.CarRepository;
import com.elm.developerChallenge.Repository.ShowroomRepository;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DatabaseSeed implements CommandLineRunner {

    private final ShowroomRepository showroomRepository;
    private final CarRepository carRepository;
    private final Faker faker = new Faker();

    @Override
    public void run(String... args) throws Exception {
        if (showroomRepository.count() == 0) {
            insertShowrooms();
        }

        if (carRepository.count() == 0) {
            insertCars();
        }
    }

    private void insertShowrooms() {
        if (showroomRepository.count() > 0) {
            System.out.println("✅ Showrooms already inserted.");
            return;
        }

        for (int i = 1; i <= 20; i++) {
            ShowroomEntity showroom = new ShowroomEntity(
                    null,
                    "Showroom " + i,
                    "CRN" + i,
                    faker.name().fullName(),
                    "055" + faker.number().digits(7),
                    faker.address().fullAddress(),
                    new ArrayList<>(),
                    null,
                    null,
                    true
            );
            System.out.println(showroom.toString());
            showroomRepository.save(showroom);
            System.out.println( showroomRepository.save(showroom));

        }
    }

    private void insertCars() {
        // First, check if cars are already inserted
        if (carRepository.count() > 0) {
            System.out.println("✅ Cars already inserted.");
            return;
        }

        // Ensure showrooms are inserted before inserting cars
        if (showroomRepository.count() == 0) {  // Corrected to check if showrooms are not available
            System.out.println("❌ No showrooms available. Please insert showrooms first.");
            return;  // Exit if no showrooms exist
        }

        List<ShowroomEntity> showrooms = showroomRepository.findAll();

        // Insert 20 cars
        for (int i = 1; i <= 20; i++) {
            ShowroomEntity showroom = showrooms.get(i % showrooms.size()); // Ensure we have a showroom
            CarEntity car = new CarEntity(
                    UUID.randomUUID().toString(),
                    "VIN" + i,
                    faker.company().name(),
                    faker.ancient().god(), // Just for fun
                    String.valueOf(2020 + (i % 5)),
                    (double) (20000 + faker.number().numberBetween(1000, 10000)),
                    showroom,
                    Instant.now(),
                    Instant.now(),
                    true
            );
            carRepository.save(car);
        }

        System.out.println("✅ Cars successfully inserted.");
    }

}

