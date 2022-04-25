package lab.exercise.service.impl;

import lab.exercise.model.Country;
import lab.exercise.repository.CountryRepository;
import lab.exercise.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> save(String name, String continent) {
        Country c = new Country(name,continent);
        this.countryRepository.save(c);
        return Optional.of(c);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }


}
