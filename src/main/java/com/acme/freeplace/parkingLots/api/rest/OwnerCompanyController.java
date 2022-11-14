package com.acme.freeplace.parkingLots.api.rest;

import com.acme.freeplace.parkingLots.domain.service.OwnerCompanyService;
import com.acme.freeplace.parkingLots.mapping.OwnerCompanyMapper;
import com.acme.freeplace.parkingLots.resource.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/ownerCompany", produces = "application/json")
public class OwnerCompanyController {

    private final OwnerCompanyService ownerCompanyService;

    private final OwnerCompanyMapper mapper;

    public OwnerCompanyController(OwnerCompanyService ownerCompanyService, OwnerCompanyMapper mapper) {
        this.ownerCompanyService = ownerCompanyService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<OwnerCompanyResource> getAllParkingLot(Pageable pageable) {
        return mapper.modelListPage(ownerCompanyService.getAll(), pageable);
    }

    @GetMapping("{ownerCompanyId}")
    public OwnerCompanyResource getOwnerCompanyById(@PathVariable Long ownerCompanyId) {
        return mapper.toResource(ownerCompanyService.getById(ownerCompanyId));
    }

    @PostMapping
    public ResponseEntity<OwnerCompanyResource> createOwnerCompany(@RequestBody CreateOwnerCompanyResource resource) {
        return new ResponseEntity<>(mapper.toResource(ownerCompanyService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{ownerCompanyId}")
    public OwnerCompanyResource updateOwnerCompany(@PathVariable Long ownerCompanyId,
                                               @RequestBody UpdateOwnerCompanyResource resource) {
        return mapper.toResource(ownerCompanyService.update(ownerCompanyId, mapper.toModel(resource)));
    }

    @DeleteMapping("{ownerCompanyId}")
    public ResponseEntity<?> deleteOwnerCompany(@PathVariable Long ownerCompanyId) {
        return ownerCompanyService.delete(ownerCompanyId);
    }


}
