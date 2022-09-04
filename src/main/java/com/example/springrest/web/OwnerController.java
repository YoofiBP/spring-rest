package com.example.springrest.web;

import com.example.springrest.domain.Owner;
import com.example.springrest.domain.OwnerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerRepository ownerRepository;

    public OwnerController(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @GetMapping
    public Iterable<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }
}
