package com.acme.freeplace.booking.service;

import com.acme.freeplace.booking.api.internal.BookingContextFacade;
import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.booking.domain.model.entity.Reviews;
import com.acme.freeplace.booking.domain.service.ReservationService;
import com.acme.freeplace.booking.domain.service.ReviewService;

import java.util.List;

public class BookingContextFacadeImpl implements BookingContextFacade {

    private final ReservationService reservationService;
    private final ReviewService reviewService;

    public BookingContextFacadeImpl(ReservationService reservationService, ReviewService reviewService) {
        this.reservationService = reservationService;
        this.reviewService = reviewService;
    }

    @Override
    public List<Reservation> GetAllReservations() {
        return reservationService.getAll();
    }

    @Override
    public List<Reviews> GetAllReviews() {
        return reviewService.GetAll();
    }

    @Override
    public int GetTotalReservation() {
        return reservationService.getAll().size();
    }

    @Override
    public int GetTotalReview() {
        return reviewService.GetAll().size();
    }
}
