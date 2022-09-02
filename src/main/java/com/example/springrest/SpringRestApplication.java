package com.example.springrest;

import com.example.springrest.domain.Car;
import com.example.springrest.domain.CarRepository;
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

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        carRepository.saveAll(
                List.of(
                        new Car("Ford", "Mustang", "Red",
                                "ADF-1121", 2021, 59000),
                        new Car("Nissan", "Leaf",
                                "White",
                                "SSJ-3002", 2019, 29000),
                        new Car("Toyota", "Prius",
                                "Silver",
                                "KO-0212", 2020, 39000)
                ));

        logger.info(carRepository.findByBrand("Toyota" ).toString());
    }
}
