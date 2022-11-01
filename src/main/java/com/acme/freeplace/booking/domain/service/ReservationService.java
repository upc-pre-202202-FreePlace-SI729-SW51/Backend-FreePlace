package com.acme.freeplace.booking.domain.service;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAll();
    Page<Reservation> getAll(Pageable pageable);
    Reservation getById(Long reservationId);
    Reservation create(Reservation reservation);
    Reservation update(Long reservationId, Reservation request);
    ResponseEntity<?> delete(Long reservationId);
}
