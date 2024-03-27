package mk.ukim.finki.stayhub.service;

import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.Host;

import java.util.List;

public interface HostService {
    List<Host> listAll();
    Host findById(Long id);
    Host create(String name, String surname, Country country);
    Host update(Long id, String name, String surname, Country country);
    Host delete(Long id);
}
