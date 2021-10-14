package tech.company.service;

import tech.company.dao.ImageRepository;
import tech.company.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class ReviewService {

  private Map<Long, Review> reviewsStore = new HashMap<>();

  private Map<Review, Long> reviewsModifiedCounter = new HashMap<>();

  @Autowired public ImageRepository imageRepository;

  private long SEQUENCE = 0;

  public long addReview(String comment, byte[] image) {
    long id = ++SEQUENCE;
    reviewsStore.put(id, Review.builder().comment(comment).build());
    if (image != null) {
      saveImage(id, image);
    }
    return id;
  }

  public long addReview(String comment) {
    return addReview(comment, null);
  }

  public long modifyReviewComment(long reviewId, String comment) {
    Review review = reviewsStore.get(reviewId);
    review.setComment(comment);
    Long count = reviewsModifiedCounter.get(review);
    count = count == null ? 0 : count + 1;
    reviewsModifiedCounter.put(review, count);
    return count;
  }

  @Transactional
  protected void saveImage(long reviewId, byte[] image) {
    imageRepository.save(reviewId, image);
  }
}
