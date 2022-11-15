package com.acme.freeplace.parkingLots.service;

import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.parkingLots.domain.persistence.ParkingLotRepository;
import com.acme.freeplace.parkingLots.domain.service.ParkingLotService;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import com.acme.freeplace.shared.excepion.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ParkingLotServiceImpl implements ParkingLotService {


    private static final String ENTITY = "ParkingLot";

    private final ParkingLotRepository parkingLotRepository;

    private final Validator validator;

    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository, Validator validator) {
        this.parkingLotRepository = parkingLotRepository;
        this.validator = validator;
    }


    @Override
    public List<ParkingLot> getAll() {

        return parkingLotRepository.findAll();
    }

    @Override
    public Page<ParkingLot> getAll(Pageable pageable) {

        return parkingLotRepository.findAll(pageable);
    }

    @Override
    public ParkingLot getById(Long parkingLotId) {
        return parkingLotRepository.findById(parkingLotId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, parkingLotId));
    }

    @Override
    public ParkingLot create(ParkingLot parkingLot) {

        return parkingLotRepository.save(parkingLot);
    }

    @Override
    public ParkingLot update(Long parkingLotId, ParkingLot request) {

        return parkingLotRepository.findById(parkingLotId).map(student ->
                        parkingLotRepository.save(
                                student.withOwner(request.getOwner())
                                        .withSpaceAvailable(request.getSpaceAvailable())
                                        .withSpaceFree(request.getSpaceFree())
                                        .withCost(request.getCost())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, parkingLotId));

    }

    @Override
    public ResponseEntity<?> delete(Long parkingLotId) {
        return parkingLotRepository.findById(parkingLotId).map(student -> {
            parkingLotRepository.delete(student);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, parkingLotId));
    }
}
