package com.example.springrest;

import com.example.springrest.domain.Car;
import com.example.springrest.domain.CarRepository;
import com.example.springrest.domain.Owner;
import com.example.springrest.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class SpringRestApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(CarRepository.class);

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Owner yoofi = ownerRepository.save(new Owner("Yoofi", "Brown-Pobee" ));
        Owner naa = ownerRepository.save(new Owner("Naa", "Harding" ));
        Owner calvin = ownerRepository.save(new Owner("Calvin", "Mends" ));
        carRepository.saveAll(
                List.of(
                        new Car("Ford", "Mustang", "Red",
                                "ADF-1121", 2021, 59000, yoofi),
                        new Car("Nissan", "Leaf",
                                "White",
                                "SSJ-3002", 2019, 29000, naa),
                        new Car("Toyota", "Prius",
                                "Silver",
                                "KO-0212", 2020, 39000, calvin)
                ));

        logger.info(carRepository.findByBrand("Toyota" ).toString());
    }
}
