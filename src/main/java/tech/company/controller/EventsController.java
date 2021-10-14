package tech.company.controller;

import tech.company.model.EventType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventsController {

  public static List<EventType> IGNORED_EVENTS = new ArrayList<>();

  static {
    IGNORED_EVENTS.add(EventType.REVIEW_APPROVED);
    IGNORED_EVENTS.add(EventType.REVIEW_DELETED);
  }

  @PostMapping
  public void addIgnoredEvent(EventType eventType) {
    IGNORED_EVENTS.add(eventType);
  }

  @DeleteMapping
  public void removeIgnoredEvent(EventType eventType) {
    IGNORED_EVENTS.remove(eventType);
  }
}
