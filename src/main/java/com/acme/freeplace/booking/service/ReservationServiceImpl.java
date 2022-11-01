package com.acme.freeplace.booking.service;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.booking.domain.persistence.ReservationRepository;
import com.acme.freeplace.booking.domain.service.ReservationService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final String ENTITY = "Reservation";

    private final ReservationRepository reservationRepository;

    private final Validator validator;

    public ReservationServiceImpl(ReservationRepository reservationRepository, Validator validator) {
        this.reservationRepository = reservationRepository;
        this.validator = validator;
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();

    }

    @Override
    public Page<Reservation> getAll(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }

    @Override
    public Reservation getById(Long reservationId) {
        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, reservationId));    }

    @Override
    public Reservation create(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Long reservationId, Reservation request) {
        return reservationRepository.findById(reservationId).map(reservation ->
                        reservationRepository.save(
                                    reservation.withDriver(request.getDriver())
                                        .withParkingLot(request.getParkingLot())
                                        .withStartTime(request.getStartTime())
                                        .withDurationMinutes(request.getDurationMinutes())
                                        .withBookingDate(request.getBookingDate())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, reservationId));
    }

    @Override
    public ResponseEntity<?> delete(Long reservationId) {
        return reservationRepository.findById(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, reservationId));
    }
}
