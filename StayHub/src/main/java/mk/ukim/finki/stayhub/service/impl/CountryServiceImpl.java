package mk.ukim.finki.stayhub.service.impl;

import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.exeptions.InvalidCountryIdException;
import mk.ukim.finki.stayhub.repository.CountryRepository;
import mk.ukim.finki.stayhub.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(InvalidCountryIdException::new);
    }

    @Override
    public Country create(String name, String continent) {
        return countryRepository.save(new Country(name,continent));
    }

    @Override
    public Country update(Long id, String name, String continent) {
        Country c = findById(id);
        c.setName(name);
        c.setContinent(continent);
        return countryRepository.save(c);
    }

    @Override
    public Country delete(Long id) {
        Country c = findById(id);
        countryRepository.delete(c);
        return c;
    }
}
