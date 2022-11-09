package com.acme.freeplace.booking.service;

import antlr.collections.List;
import com.acme.freeplace.booking.domain.model.entity.ParkingSlip;
import com.acme.freeplace.booking.domain.persistence.ParkingSlipRepository;
import com.acme.freeplace.booking.domain.service.ParkingSlipService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import javax.validation.Validator;

public class ParkingSlipServiceImpl implements ParkingSlipService {

    private static final String ENTITY = "ParkingSlip";

    private final ParkingSlipRepository parkingSlipRepository;

    private final Validator validator;

    public ParkingSlipServiceImpl(ParkingSlipRepository parkingSlipRepository, Validator validator) {
        this.parkingSlipRepository = parkingSlipRepository;
        this.validator = validator;
    }


    @java.lang.Override
    public List<ParkingSlip> GetAll() {
        return parkingSlipRepository.findAll();
    }

    @java.lang.Override
    public Page<ParkingSlip> GetAll(Pageable pageable) {
        return parkingSlipRepository.findAll(pageable);
    }

    @java.lang.Override
    public ParkingSlip GetById(Long parkingSlipId) {
        return parkingSlipRepository.findById(parkingSlipId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,parkingSlipId));
    }

    @java.lang.Override
    public ParkingSlip Create(ParkingSlip parkingSlip) {
        return parkingSlipRepository.save(parkingSlip);
    }

    @java.lang.Override
    public ParkingSlip Update(Long parkingSlipId, ParkingSlip parkingSlip) {
        return parkingSlipRepository.findById(parkingSlipId).map(parkingSlip->
                parkingSlipRepository.save(
                        parkingSlip.withReservation(request.getReservation)
                                .withEntryTime(request.getEntryTime)
                                .withEntryExit(request.getEntryExit)
                                .withTotalCost(request.getTotalCost)))
                        .orElseThrow(()-> new ResourceNotFoundException(ENTITY,parkingSlipId));
    }

    @java.lang.Override
    public ResponseEntity<?> Delete(Long parkingSlipId) {
        return parkingSlipRepository.findById(parkingSlipId).map(parkingSlip->{
            parkingSlipRepository.delete(parkingSlip);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,parkingSlipId));
    }
}
