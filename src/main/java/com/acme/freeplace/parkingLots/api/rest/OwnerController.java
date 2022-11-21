package com.acme.freeplace.parkingLots.api.rest;

import com.acme.freeplace.parkingLots.domain.service.OwnerService;
import com.acme.freeplace.parkingLots.mapping.OwnerMapper;
import com.acme.freeplace.parkingLots.resource.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/owner", produces = "application/json")
@CrossOrigin(origins = "*")
public class OwnerController {

    private final OwnerService ownerService;

    private final OwnerMapper mapper;

    public OwnerController(OwnerService ownerService, OwnerMapper mapper) {
        this.ownerService = ownerService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<OwnerResource> getAllOwner(Pageable pageable) {
        return mapper.modelListPage(ownerService.getAll(), pageable);
    }

    @GetMapping("{ownerCompanyId}")
    public OwnerResource getOwnerById(@PathVariable Long ownerCompanyId) {
        return mapper.toResource(ownerService.getById(ownerCompanyId));
    }

    @PostMapping
    public ResponseEntity<OwnerResource> createOwner(@RequestBody CreateOwnerResource resource) {
        return new ResponseEntity<>(mapper.toResource(ownerService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{ownerCompanyId}")
    public OwnerResource updateOwner(@PathVariable Long ownerCompanyId,
                                            @RequestBody UpdateOwnerResource resource) {
        return mapper.toResource(ownerService.update(ownerCompanyId, mapper.toModel(resource)));
    }

    @DeleteMapping("{ownerCompanyId}")
    public ResponseEntity<?> deleteOwner(@PathVariable Long ownerCompanyId) {
        return ownerService.delete(ownerCompanyId);
    }


}
