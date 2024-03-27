package mk.ukim.finki.stayhub.service;

import mk.ukim.finki.stayhub.model.Category;
import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.Host;
import mk.ukim.finki.stayhub.model.Housing;

import java.util.List;

public interface HousingService {
    List<Housing> listAll();
    Housing findById(Long id);
    Housing create(String name, Category category, Host host, int numRooms);
    Housing update(Long id, String name, Category category, Host host, int numRooms);
    Housing delete(Long id);
    Housing mark(Long id);
    void onHousingCreated();
    void onHousingEdited();
    void onHousingDeleted();
}
