package com.acme.freeplace.security.register.mapping;

import com.acme.freeplace.security.register.domain.model.Business;
import com.acme.freeplace.security.register.resource.BusinessResource;
import com.acme.freeplace.security.register.resource.CreateBusinessResource;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BusinessMapper {
    @Autowired
    EnhancedModelMapper mapper;
    public BusinessResource toResource(Business model){
        return mapper.map(model,BusinessResource.class);
    }
    public Business toModel(CreateBusinessResource resource){
        return mapper.map(resource, Business.class);
    }
}
