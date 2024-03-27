package mk.ukim.finki.stayhub.model.dto;

import lombok.Data;
import mk.ukim.finki.stayhub.model.Category;
import mk.ukim.finki.stayhub.model.Host;

@Data
public class HousingDto {
    String name;
    Category category;
    Host host;
    int numRooms;
}
