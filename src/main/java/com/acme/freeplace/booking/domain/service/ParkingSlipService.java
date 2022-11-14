package com.acme.freeplace.booking.domain.service;

import com.acme.freeplace.booking.domain.model.entity.ParkingSlip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingSlipService {

    List<ParkingSlip> GetAll();
    Page<ParkingSlip> GetAll(Pageable pageable);
    ParkingSlip GetById(Long parkingSlipId);
    ParkingSlip Create(ParkingSlip parkingSlip);
    ParkingSlip Update(Long parkingSlipId, ParkingSlip parkingSlip);
    ResponseEntity<?> Delete(Long parkingSlipId);
}
