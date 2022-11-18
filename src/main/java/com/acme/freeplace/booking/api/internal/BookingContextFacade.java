package com.acme.freeplace.booking.api.internal;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.booking.domain.model.entity.Reviews;

import java.util.List;

public interface BookingContextFacade {
    List<Reservation> GetAllReservations();
    List<Reviews> GetAllReviews();

    int GetTotalReservation();
    int GetTotalReview();
}
