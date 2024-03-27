package mk.ukim.finki.stayhub.repository;

import mk.ukim.finki.stayhub.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
