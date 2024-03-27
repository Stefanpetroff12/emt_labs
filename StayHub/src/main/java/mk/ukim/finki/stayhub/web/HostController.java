package mk.ukim.finki.stayhub.web;

import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.Host;
import mk.ukim.finki.stayhub.model.dto.HostDto;
import mk.ukim.finki.stayhub.service.CountryService;
import mk.ukim.finki.stayhub.service.HostService;
import mk.ukim.finki.stayhub.service.HousingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class HostController {

    private final CountryService countryService;
    private final HostService hostService;
    private final HousingService housingService;

    public HostController(CountryService countryService, HostService hostService, HousingService housingService) {
        this.countryService = countryService;
        this.hostService = hostService;
        this.housingService = housingService;
    }

    @PostMapping("/add-host")
    public ResponseEntity<Void> addAuthor(@RequestBody HostDto hostDto) {
        if(hostDto == null) {
            return ResponseEntity.notFound().build();
        }

        if(countryService.findById(hostDto.getCountry().getId()) == null) {
            return ResponseEntity.notFound().build();
        }

        this.hostService.create(hostDto.getName(), hostDto.getSurname(), hostDto.getCountry());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/hosts")
    public List<Host> getHosts() {
        return this.hostService.listAll();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> getHosts(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }
        this.hostService.delete(id);
        return ResponseEntity.ok().build();
    }
}
