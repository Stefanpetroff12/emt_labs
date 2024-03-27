package mk.ukim.finki.stayhub.web;

import mk.ukim.finki.stayhub.model.Housing;
import mk.ukim.finki.stayhub.model.dto.HousingDto;
import mk.ukim.finki.stayhub.service.CountryService;
import mk.ukim.finki.stayhub.service.HostService;
import mk.ukim.finki.stayhub.service.HousingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/housing")
public class HousingController {
    private final CountryService countryService;
    private final HostService hostService;
    private final HousingService housingService;

    public HousingController(CountryService countryService, HostService hostService, HousingService housingService) {
        this.countryService = countryService;
        this.hostService = hostService;
        this.housingService = housingService;
    }

    @PostMapping("/add-housing")
    public ResponseEntity<Void> addHousing(@RequestBody HousingDto housingDto) {
        if(housingDto == null) {
            return ResponseEntity.notFound().build();
        }
        if(housingService.findById(housingDto.getHost().getId()) == null) {
            return ResponseEntity.notFound().build();
        }
        this.housingService.create(housingDto.getName(), housingDto.getCategory(), housingDto.getHost(), housingDto.getNumRooms());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/delete-housing/{id}")
    public ResponseEntity<Void> deleteHousing(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }
        if(housingService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        this.housingService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/edit-housing/{id}")
    public ResponseEntity<Void> editBook(@PathVariable Long id, @RequestBody HousingDto housingDto) {
        if(housingDto == null) {
            return ResponseEntity.notFound().build();
        }
        if(housingService.findById(housingDto.getHost().getId()) == null || housingService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        this.housingService.update(id, housingDto.getName(), housingDto.getCategory(), housingDto.getHost(), housingDto.getNumRooms());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/mark-housing/{id}")
    public ResponseEntity<Void> markHousing(@PathVariable Long id) {
        if(id == null) {
            return ResponseEntity.notFound().build();
        }
        if(housingService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        this.housingService.mark(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Housing> getHousings() {
        return this.housingService.listAll();
    }
}
