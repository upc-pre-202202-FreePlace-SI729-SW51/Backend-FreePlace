package com.acme.freeplace.booking.service;

import com.acme.freeplace.booking.domain.model.entity.ParkingSlip;
import com.acme.freeplace.booking.domain.persistence.ParkingSlipRepository;
import com.acme.freeplace.booking.domain.service.ParkingSlipService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class ParkingSlipServiceImpl implements ParkingSlipService {

    private static final String ENTITY = "ParkingSlip";

    private final ParkingSlipRepository parkingSlipRepository;

    private final Validator validator;

    public ParkingSlipServiceImpl(ParkingSlipRepository parkingSlipRepository, Validator validator) {
        this.parkingSlipRepository = parkingSlipRepository;
        this.validator = validator;
    }


    @Override
    public List<ParkingSlip> GetAll() {
        return parkingSlipRepository.findAll();
    }

    @Override
    public Page<ParkingSlip> GetAll(Pageable pageable) {
        return parkingSlipRepository.findAll(pageable);
    }

    @Override
    public ParkingSlip GetById(Long parkingSlipId) {
        return parkingSlipRepository.findById(parkingSlipId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,parkingSlipId));
    }

    @Override
    public ParkingSlip Create(ParkingSlip parkingSlip) {
        return parkingSlipRepository.save(parkingSlip);
    }

    @Override
    public ParkingSlip Update(Long parkingSlipId, ParkingSlip request) {
       return parkingSlipRepository.findById(parkingSlipId).map(parkingSlip->parkingSlipRepository.save(
               parkingSlip.withReservation(request.getReservation())
                       .withEntryTime(request.getEntryTime())
                       .withEntryExit(request.getEntryExit())
                       .withTotalCost(request.getTotalCost())))
               .orElseThrow(()->new ResourceNotFoundException(ENTITY,parkingSlipId));
    }

    @Override
    public ResponseEntity<?> Delete(Long parkingSlipId) {
        return parkingSlipRepository.findById(parkingSlipId).map(parkingSlip->{
            parkingSlipRepository.delete(parkingSlip);
            return ResponseEntity.ok().build();
        }).orElseThrow(()->new ResourceNotFoundException(ENTITY,parkingSlipId));
    }
}
