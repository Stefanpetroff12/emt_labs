package mk.ukim.finki.stayhub.model.events;

import mk.ukim.finki.stayhub.model.Housing;
import org.springframework.context.ApplicationEvent;

public class HousingCreatedEvent extends ApplicationEvent {
    public HousingCreatedEvent(Housing source) {
        super(source);
    }
}
