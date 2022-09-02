package com.example.springrest.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    Iterable<Car> findByBrand(String brands);
}
