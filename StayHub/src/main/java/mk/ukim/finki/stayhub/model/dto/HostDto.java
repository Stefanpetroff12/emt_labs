package mk.ukim.finki.stayhub.model.dto;

import lombok.Data;
import mk.ukim.finki.stayhub.model.Country;

@Data
public class HostDto {
    String name;
    String surname;
    Country country;
}
