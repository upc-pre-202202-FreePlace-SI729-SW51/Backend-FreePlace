package com.acme.freeplace.booking.api.rest;

import com.acme.freeplace.booking.domain.service.ReservationService;
import com.acme.freeplace.booking.mapping.ReservationMapper;
import com.acme.freeplace.booking.resource.CreateReservationResource;
import com.acme.freeplace.booking.resource.ReservationResource;
import com.acme.freeplace.parkingLots.resource.CreateParkingLotResource;
import com.acme.freeplace.parkingLots.resource.ParkingLotResource;
import com.acme.freeplace.parkingLots.resource.UpdateParkingLotResource;
import com.acme.freeplace.profile.resource.CreateDriverResource;
import com.acme.freeplace.profile.resource.DriverResource;
import com.acme.freeplace.profile.resource.UpdateDriverResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/reservations", produces = "application/json")
public class ReservationController {

    private final ReservationService reservationService;

    private final ReservationMapper mapper;

    public ReservationController(ReservationService reservationService, ReservationMapper mapper) {
        this.reservationService = reservationService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ReservationResource> getAllReservation(Pageable pageable) {
        return mapper.modelListPage(reservationService.getAll(), pageable);
    }

    @GetMapping("{reservationId}")
    public ReservationResource getReservationById(@PathVariable Long reservationId) {
        return mapper.toResource(reservationService.getById(reservationId));
    }

    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource resource) {
        return new ResponseEntity<>(mapper.toResource(reservationService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }


    @DeleteMapping("{reservationtId}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long reservationtId) {
        return reservationService.delete(reservationtId);
    }





}
