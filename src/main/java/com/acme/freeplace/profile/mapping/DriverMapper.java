package com.acme.freeplace.profile.mapping;

import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.acme.freeplace.profile.api.resource.CreateDriverResource;
import com.acme.freeplace.profile.api.resource.DriverResource;
import com.acme.freeplace.profile.api.resource.UpdateDriverResource;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class DriverMapper  implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;
    public DriverResource toResource(Driver model) {
        return mapper.map(model, DriverResource.class);
    }
    public Driver toModel(CreateDriverResource resource) {
        return mapper.map(resource, Driver.class);
    }
    public Driver toModel(UpdateDriverResource resource) {
        return mapper.map(resource, Driver.class);
    }
    public Page<DriverResource> modelListPage(List<Driver> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, DriverResource.class), pageable, modelList.size());
    }

}
