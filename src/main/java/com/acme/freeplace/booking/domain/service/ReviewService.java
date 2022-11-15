package com.acme.freeplace.booking.domain.service;

import com.acme.freeplace.booking.domain.model.entity.Reviews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReviewService {
    List<Reviews> GetAll();
    Page<Reviews> GetAll(Pageable pageable);
    Reviews GetById(Long reviewId);
    Reviews Create(Reviews reviews);
    Reviews Update(Long reviewId, Reviews reviews);
    ResponseEntity<?> Delete(Long reviewId);

}
