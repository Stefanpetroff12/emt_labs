package mk.ukim.finki.stayhub.listeners;

import mk.ukim.finki.stayhub.model.events.HousingCreatedEvent;
import mk.ukim.finki.stayhub.model.events.HousingDeletedEvent;
import mk.ukim.finki.stayhub.model.events.HousingEditedEvent;
import mk.ukim.finki.stayhub.service.HousingService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HousingEventHandlers {
    private final HousingService housingService;

    public HousingEventHandlers(HousingService housingService) {
        this.housingService = housingService;
    }

    @EventListener
    public void onHousingCreated(HousingCreatedEvent event) {
        this.housingService.onHousingCreated();
    }

    @EventListener
    public void onHousingDeleted(HousingDeletedEvent event) {
        this.housingService.onHousingDeleted();
    }

    @EventListener
    public void onHousingEdited(HousingEditedEvent event) {
        this.housingService.onHousingEdited();
    }
}
