package com.acme.freeplace.booking.api.rest;


import com.acme.freeplace.booking.domain.service.ReviewService;
import com.acme.freeplace.booking.mapping.ReviewsMapper;
import com.acme.freeplace.booking.resource.CreateReviewResource;
import com.acme.freeplace.booking.resource.ReviewsResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/reviews", produces = "application/json")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewsMapper mapper;

    public ReviewController(ReviewService reviewService, ReviewsMapper mapper) {
        this.reviewService = reviewService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ReviewsResource> GetAllReviews(Pageable pageable){
        return mapper.modelListPage(reviewService.GetAll(),pageable);
    }

    @GetMapping("{reviewId}")
    public ReviewsResource GetReviewsById(@PathVariable Long reviewId){
        return mapper.toResource(reviewService.GetById(reviewId));
    }

    @PostMapping
    public ResponseEntity<ReviewsResource> CreateReview(@RequestBody CreateReviewResource resource){
        return new ResponseEntity<>(mapper.toResource(reviewService.Create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @DeleteMapping("{reviewId}")
    public ResponseEntity<?> DeleteReview(@PathVariable Long reviewId){
        return reviewService.Delete(reviewId);
    }
}
