package mk.ukim.finki.stayhub.model.events;

import mk.ukim.finki.stayhub.model.Housing;
import org.springframework.context.ApplicationEvent;

public class HousingEditedEvent extends ApplicationEvent {
    public HousingEditedEvent(Housing source) {
        super(source);
    }
}
