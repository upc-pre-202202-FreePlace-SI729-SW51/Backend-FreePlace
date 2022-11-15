package com.acme.freeplace.booking.service;

import com.acme.freeplace.booking.domain.model.entity.Reviews;
import com.acme.freeplace.booking.domain.persistence.ReviewRepository;
import com.acme.freeplace.booking.domain.service.ReviewService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static final String ENTITY = "Review";

    private final ReviewRepository reviewRepository;

    private final Validator validator;

    public ReviewServiceImpl(ReviewRepository reviewRepository, Validator validator) {
        this.reviewRepository = reviewRepository;
        this.validator = validator;
    }

    @Override
    public List<Reviews> GetAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Page<Reviews> GetAll(Pageable pageable) {
        return reviewRepository.findAll(pageable);
    }

    @Override
    public Reviews GetById(Long reviewId) {
        return reviewRepository.findById(reviewId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,reviewId));
    }

    @Override
    public Reviews Create(Reviews reviews) {
        return reviewRepository.save(reviews);
    }

    @Override
    public Reviews Update(Long reviewId, Reviews reviews) {
        return reviewRepository.findById(reviewId).map(review->reviewRepository.save(
                reviews.withReservation(reviews.getReservation())
                        .withComment(reviews.getComment())
                        .withStars(reviews.getStars())))
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,reviewId));
    }

    @Override
    public ResponseEntity<?> Delete(Long reviewId) {
        return reviewRepository.findById(reviewId).map(reviews -> {
            reviewRepository.delete(reviews);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,reviewId));
    }
}
