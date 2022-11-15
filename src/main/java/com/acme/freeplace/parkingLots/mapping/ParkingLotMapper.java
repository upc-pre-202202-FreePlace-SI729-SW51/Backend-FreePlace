package com.acme.freeplace.parkingLots.mapping;

import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.parkingLots.resource.CreateParkingLotResource;
import com.acme.freeplace.parkingLots.resource.ParkingLotResource;
import com.acme.freeplace.parkingLots.resource.UpdateParkingLotResource;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.acme.freeplace.profile.resource.CreateDriverResource;
import com.acme.freeplace.profile.resource.DriverResource;
import com.acme.freeplace.profile.resource.UpdateDriverResource;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ParkingLotMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public ParkingLotResource toResource(ParkingLot model) {
        return mapper.map(model, ParkingLotResource.class);
    }

    public ParkingLot toModel(CreateParkingLotResource resource) {
        return mapper.map(resource, ParkingLot.class);
    }

    public ParkingLot toModel(UpdateParkingLotResource resource) {
        return mapper.map(resource, ParkingLot.class);
    }

    public Page<ParkingLotResource> modelListPage(List<ParkingLot> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ParkingLotResource.class), pageable, modelList.size());
    }
}
