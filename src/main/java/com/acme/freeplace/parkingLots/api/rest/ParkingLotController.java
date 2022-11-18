package com.acme.freeplace.parkingLots.api.rest;


import com.acme.freeplace.parkingLots.domain.service.ParkingLotService;
import com.acme.freeplace.parkingLots.mapping.ParkingLotMapper;
import com.acme.freeplace.parkingLots.resource.CreateParkingLotResource;
import com.acme.freeplace.parkingLots.resource.ParkingLotResource;
import com.acme.freeplace.parkingLots.resource.UpdateParkingLotResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/parkingLots", produces = "application/json")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    private final ParkingLotMapper mapper;

    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper mapper) {
        this.parkingLotService = parkingLotService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ParkingLotResource> getAllParkingLot(Pageable pageable) {
        return mapper.modelListPage(parkingLotService.getAll(), pageable);
    }

    @GetMapping("{parkingLotId}")
    public ParkingLotResource getParkingLotById(@PathVariable Long parkingLotId) {
        return mapper.toResource(parkingLotService.getById(parkingLotId));
    }

    @PostMapping
    public ResponseEntity<ParkingLotResource> createParkingLot(@RequestBody CreateParkingLotResource resource) {
        return new ResponseEntity<>(mapper.toResource(parkingLotService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{parkingLotId}")
    public ParkingLotResource updateParkingLot(@PathVariable Long parkingLotId,
                                        @RequestBody UpdateParkingLotResource resource) {
        return mapper.toResource(parkingLotService.update(parkingLotId, mapper.toModel(resource)));
    }

    @DeleteMapping("{parkingLotId}")
    public ResponseEntity<?> deleteParkingLot(@PathVariable Long parkingLotId) {
        return parkingLotService.delete(parkingLotId);
    }




}
