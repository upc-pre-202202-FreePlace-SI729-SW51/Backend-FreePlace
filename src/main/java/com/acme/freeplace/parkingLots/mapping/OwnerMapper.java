package com.acme.freeplace.parkingLots.mapping;

import com.acme.freeplace.parkingLots.domain.model.entity.Owner;
import com.acme.freeplace.parkingLots.resource.*;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class OwnerMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public OwnerResource toResource(Owner model) {
        return mapper.map(model, OwnerResource.class);
    }

    public Owner toModel(CreateOwnerResource resource) {
        return mapper.map(resource, Owner.class);
    }

    public Owner toModel(UpdateOwnerResource resource) {
        return mapper.map(resource, Owner.class);
    }

    public Page<OwnerResource> modelListPage(List<Owner> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OwnerResource.class), pageable, modelList.size());
    }
}
