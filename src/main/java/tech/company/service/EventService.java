package tech.company.service;

import tech.company.model.Event;
import tech.company.model.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@Slf4j
public class EventService {

  public Lock lock = new ReentrantLock();

  public void processEvent(Event event) {
    lock.lock();
    if (event.getType() == EventType.REVIEW_APPROVED) {
      processApproved(event.getId(), event.getPayload());
    } else if (event.getType() == EventType.REVIEW_CREATED) {
      processCreated(event.getId(), event.getPayload());
    } else if (event.getType() == EventType.REVIEW_DELETED) {
      processDeleted(event.getId(), event.getPayload());
    }
    lock.unlock();
  }

  private void processDeleted(String id, String payload) {
    throw new Error("Deleted event is temporary deprecated!");
  }

  private void processCreated(String id, String payload) {
    log.info("Created: id: {}, payload: {}", id, payload);
  }

  private void processApproved(String id, String payload) {
    throw new Error("Approved event is temporary deprecated!");
  }
}
