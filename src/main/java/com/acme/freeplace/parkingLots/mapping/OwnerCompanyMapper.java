package com.acme.freeplace.parkingLots.mapping;

import com.acme.freeplace.parkingLots.domain.model.entity.OwnerCompany;
import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.parkingLots.resource.*;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OwnerCompanyMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public OwnerCompanyResource toResource(OwnerCompany model) {
        return mapper.map(model, OwnerCompanyResource.class);
    }

    public OwnerCompany toModel(CreateOwnerCompanyResource resource) {
        return mapper.map(resource, OwnerCompany.class);
    }

    public OwnerCompany toModel(UpdateOwnerCompanyResource resource) {
        return mapper.map(resource, OwnerCompany.class);
    }

    public Page<OwnerCompanyResource> modelListPage(List<OwnerCompany> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OwnerCompanyResource.class), pageable, modelList.size());
    }
}
