package com.acme.freeplace.security.register.api;

import com.acme.freeplace.security.register.domain.service.BusinessService;
import com.acme.freeplace.security.register.mapping.BusinessMapper;
import com.acme.freeplace.security.register.resource.BusinessResource;
import com.acme.freeplace.security.register.resource.CreateBusinessResource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/businesses")
@CrossOrigin
    public class BusinessesController {
        private final BusinessService businessService;
    private final BusinessMapper mapper;

    public BusinessesController(BusinessService businessService, BusinessMapper mapper) {
        this.businessService = businessService;
        this.mapper = mapper;
    }
    @GetMapping("{businessId}")
    public BusinessResource getById(@PathVariable Long businessId){
        return mapper.toResource(businessService.getById(businessId));
    }
    @PostMapping
    public BusinessResource create(@RequestBody CreateBusinessResource resource){
        return mapper.toResource(businessService.create(mapper.toModel(resource)));
    }
}
