package mk.ukim.finki.stayhub.service.impl;

import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.Host;
import mk.ukim.finki.stayhub.model.exeptions.InvalidHostIdException;
import mk.ukim.finki.stayhub.repository.HostRepository;
import mk.ukim.finki.stayhub.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostServiceImpl implements HostService {
    private final HostRepository hostRepository;

    public HostServiceImpl(HostRepository hostRepository) {
        this.hostRepository = hostRepository;
    }

    @Override
    public List<Host> listAll() {
        return hostRepository.findAll();
    }

    @Override
    public Host findById(Long id) {
        return hostRepository.findById(id).orElseThrow(InvalidHostIdException::new);
    }

    @Override
    public Host create(String name, String surname, Country country) {
        return hostRepository.save(new Host(name,surname,country));
    }

    @Override
    public Host update(Long id, String name, String surname, Country country) {
        Host c = findById(id);
        c.setName(name);
        c.setSurname(surname);
        c.setCountry(country);
        return hostRepository.save(c);
    }

    @Override
    public Host delete(Long id) {
        Host c = findById(id);
        hostRepository.delete(c);
        return c;
    }
}
