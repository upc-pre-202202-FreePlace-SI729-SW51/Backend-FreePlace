package com.acme.freeplace.parkingLots.api.internal;

import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;

import java.util.List;

public interface ParkingLotContextFacade {

    List<ParkingLot> GetAllParkingLots();

    int GetTotalParkingLots();

}
