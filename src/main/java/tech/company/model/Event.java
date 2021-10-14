package tech.company.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
  private String id;
  private EventType type;
  private String payload;
}
