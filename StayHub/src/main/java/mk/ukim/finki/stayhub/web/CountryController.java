package mk.ukim.finki.stayhub.web;

import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.dto.CountryDto;
import mk.ukim.finki.stayhub.service.CountryService;
import mk.ukim.finki.stayhub.service.HostService;
import mk.ukim.finki.stayhub.service.HousingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/country")
public class CountryController {
    private final CountryService countryService;
    private final HostService hostService;
    private final HousingService housingService;

    public CountryController(CountryService countryService, HostService hostService, HousingService housingService) {
        this.countryService = countryService;

        this.hostService = hostService;
        this.housingService = housingService;
    }

    @PostMapping("/add-country")
    public ResponseEntity<Void> addCountry(@RequestBody CountryDto countryDTO) {
        if(countryDTO == null) {
            return ResponseEntity.notFound().build();
        }

        this.countryService.create(countryDTO.getName(), countryDTO.getContinent());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return this.countryService.listAll();
    }

}
