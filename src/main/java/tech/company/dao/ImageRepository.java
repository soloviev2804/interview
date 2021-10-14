package tech.company.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/** STUB for JPA repository */
@Slf4j
@Component
public class ImageRepository {
  public void save(long id, byte[] image) {
    log.info("Image with id {} was saved", id);
  }
}
