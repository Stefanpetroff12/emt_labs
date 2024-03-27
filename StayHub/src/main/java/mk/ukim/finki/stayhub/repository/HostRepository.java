package mk.ukim.finki.stayhub.repository;

import mk.ukim.finki.stayhub.model.Country;
import mk.ukim.finki.stayhub.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host,Long> {
}
