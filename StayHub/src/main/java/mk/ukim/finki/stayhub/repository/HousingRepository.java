package mk.ukim.finki.stayhub.repository;

import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.Housing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HousingRepository extends JpaRepository<Housing,Long> {
}
