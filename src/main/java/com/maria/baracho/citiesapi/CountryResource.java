package com.maria.baracho.citiesapi;

import com.maria.baracho.citiesapi.countries.Country;
import com.maria.baracho.citiesapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page);
    }

    @GetMapping("/{id}")
    public Country getOne(@PathVariable Long id) {
        Optional<Country> country = repository.findById(id);
        return country.get();
    }
}
