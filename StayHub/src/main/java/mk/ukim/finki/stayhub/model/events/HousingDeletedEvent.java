package mk.ukim.finki.stayhub.model.events;

import mk.ukim.finki.stayhub.model.Housing;
import org.springframework.context.ApplicationEvent;

public class HousingDeletedEvent extends ApplicationEvent {

    public HousingDeletedEvent(Housing source) {
        super(source);
    }
}
