package com.acme.freeplace.profile.api.rest;


import com.acme.freeplace.profile.domain.service.DriverService;
import com.acme.freeplace.profile.mapping.DriverMapper;
import com.acme.freeplace.profile.api.resource.CreateDriverResource;
import com.acme.freeplace.profile.api.resource.DriverResource;
import com.acme.freeplace.profile.api.resource.UpdateDriverResource;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping(value = "/api/v1/drivers", produces = "application/json")
public class DriverController {


    private final DriverService driverService;

   private final DriverMapper mapper;


    public DriverController(DriverService driverService, DriverMapper mapper) {
        this.driverService = driverService;

        this.mapper = mapper;
    }

    @GetMapping
    public Page<DriverResource> getAllDriver(Pageable pageable) {
        return mapper.modelListPage(driverService.getAll(), pageable);
    }

    @GetMapping("{driverId}")
    public DriverResource getDriverById(@PathVariable Long driverId) {
        return mapper.toResource(driverService.getById(driverId));
    }

    @PostMapping
    public ResponseEntity<DriverResource> createDriver(@RequestBody CreateDriverResource resource) {
        return new ResponseEntity<>(mapper.toResource(driverService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }
    @PutMapping("{driverId}")
    public DriverResource updateStudent(@PathVariable Long driverId,
                                         @RequestBody UpdateDriverResource resource) {
        return mapper.toResource(driverService.update(driverId, mapper.toModel(resource)));
    }

    @DeleteMapping("{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long driverId) {

        return driverService.delete(driverId);
    }
}
