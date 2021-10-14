package tech.company.messaging;

import tech.company.controller.EventsController;
import tech.company.model.Event;
import tech.company.service.EventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Listener {

  @Autowired public EventService eventService;

  // imitates some MQ listener method
  public void onEvent(Event event) {
    if (EventsController.IGNORED_EVENTS.contains(event.getType())) {
      log.info("Event {} was ignored", event.toString());
    }
    processEvent(event);
  }

  private void processEvent(Event event) {
    eventService.processEvent(event);
    log.info("Event {} was processed", event);
  }
}
