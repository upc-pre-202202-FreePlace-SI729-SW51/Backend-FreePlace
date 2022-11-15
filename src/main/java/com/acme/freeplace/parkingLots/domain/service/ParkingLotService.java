package com.acme.freeplace.parkingLots.domain.service;

import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingLotService {


    List<ParkingLot> getAll();
    Page<ParkingLot> getAll(Pageable pageable);
    ParkingLot getById(Long parkingLotId);
    ParkingLot create(ParkingLot parkingLot);
    ParkingLot update(Long parkingLotId, ParkingLot request);
    ResponseEntity<?> delete(Long parkingLotId);
}
