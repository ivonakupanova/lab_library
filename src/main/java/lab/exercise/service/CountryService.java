package lab.exercise.service;

import lab.exercise.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    Optional<Country> save(String name, String continent);

    List<Country> findAll();
}
