package tech.company.controller;

import tech.company.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

  @Autowired public ReviewService reviewService;

  public ResponseEntity<Long> addReview(String reviewComment) {
    return ResponseEntity.ok(reviewService.addReview(reviewComment));
  }

  public ResponseEntity<Long> modifyReview(long id, String reviewComment) {
    return ResponseEntity.ok(reviewService.modifyReviewComment(id, reviewComment));
  }
}
