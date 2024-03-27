package mk.ukim.finki.stayhub.service.impl;

import mk.ukim.finki.stayhub.model.Category;
import mk.ukim.finki.stayhub.model.Host;
import mk.ukim.finki.stayhub.model.Housing;
import mk.ukim.finki.stayhub.model.exeptions.InvalidHostIdException;
import mk.ukim.finki.stayhub.model.exeptions.InvalidHousingIdException;
import mk.ukim.finki.stayhub.repository.HousingRepository;
import mk.ukim.finki.stayhub.service.HousingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HousingServiceImpl implements HousingService {
    private final HousingRepository housingRepository;

    public HousingServiceImpl(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
    }

    @Override
    public List<Housing> listAll() {
        return housingRepository.findAll();
    }

    @Override
    public Housing findById(Long id) {
        return housingRepository.findById(id).orElseThrow(InvalidHousingIdException::new);
    }

    @Override
    public Housing create(String name, Category category, Host host, int numRooms) {
        return housingRepository.save(new Housing(name,category,host, numRooms));
    }

    @Override
    public Housing update(Long id, String name, Category category, Host host, int numRooms) {
        Housing c = findById(id);
        c.setName(name);
        c.setCategory(category);
        c.setHost(host);
        c.setNumRooms(numRooms);
        return housingRepository.save(c);
    }

    @Override
    public Housing delete(Long id) {
        Housing c = findById(id);
        housingRepository.delete(c);
        return c;
    }

    @Override
    public Housing mark(Long id) {
        Housing c = findById(id);
        c.setNumRooms(c.getNumRooms() + 1);
        housingRepository.save(c);
        return c;
    }

    @Override
    public void onHousingCreated() {
        System.out.println("[CREATE]: Book created successfully");
    }

    @Override
    public void onHousingEdited() {
        System.out.println("[EDIT]: Book edited successfully");
    }

    @Override
    public void onHousingDeleted() {
        System.out.println("[DELETE]: Book deleted successfully");
    }
}
