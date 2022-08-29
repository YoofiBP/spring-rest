package com.example.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }

}

@Entity
class MyUser {

    @Id
    private UUID id;
    private int age;
    private String firstName;
    private String lastName;
    private String email;

    public MyUser(int age, String firstName, String lastName, String email) {
        this.id = UUID.randomUUID();
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public MyUser() {

    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

@RestController
@RequestMapping("/users")
class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userRepository.saveAll(List.of(new MyUser(26, "Yoofi", "Brown-Pobee", "joseph@email.com"),
                new MyUser(22, "Naa", "Harding", "naa@email.com")
        ));
    }

    @GetMapping
    Iterable<MyUser> getUsers() {
        return this.userRepository.findAll();
    }
}

interface UserRepository extends CrudRepository<MyUser, UUID> {

}

