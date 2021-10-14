package tech.company.service;

import org.junit.jupiter.api.Test;

class ReviewServiceTest {

  private ReviewService reviewService = new ReviewService();

  @Test
  void modifyReviewComment() {
    long id = reviewService.addReview("qwe");
    reviewService.modifyReviewComment(id, "qwe 1");
    reviewService.modifyReviewComment(id, "qwe 2");
    long count = reviewService.modifyReviewComment(id, "qwe 3");
    System.out.println(count);
  }
}
