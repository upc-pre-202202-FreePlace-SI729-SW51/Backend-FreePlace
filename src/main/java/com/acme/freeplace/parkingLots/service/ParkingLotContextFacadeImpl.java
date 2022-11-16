package com.acme.freeplace.parkingLots.service;

import com.acme.freeplace.parkingLots.api.internal.ParkingLotContextFacade;
import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.parkingLots.domain.service.ParkingLotService;

import java.util.List;

public class ParkingLotContextFacadeImpl implements ParkingLotContextFacade {

    private final ParkingLotService parkingLotService;

    public ParkingLotContextFacadeImpl(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @Override
    public List<ParkingLot> GetAllParkingLots() {
        return parkingLotService.getAll();
    }

    @Override
    public int GetTotalParkingLots() {
        return parkingLotService.getAll().size();
    }
}
