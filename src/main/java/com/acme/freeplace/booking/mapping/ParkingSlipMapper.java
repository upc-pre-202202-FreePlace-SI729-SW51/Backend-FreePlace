package com.acme.freeplace.booking.mapping;

import com.acme.freeplace.booking.domain.model.entity.ParkingSlip;
import com.acme.freeplace.booking.resource.CreateParkingSlipResource;
import com.acme.freeplace.booking.resource.ParkingSlipResource;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ParkingSlipMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public ParkingSlipResource toResource(ParkingSlip model){
        return mapper.map(model, ParkingSlipResource.class);
    }

    public  ParkingSlip toModel(CreateParkingSlipResource resource){
        return mapper.map(resource, ParkingSlip.class);
    }

    public Page<ParkingSlipResource> modelListPage(List<ParkingSlip> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,ParkingSlipResource.class),pageable,modelList.size());
    }

}
