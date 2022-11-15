package com.acme.freeplace.booking.api.rest;


import com.acme.freeplace.booking.domain.service.ParkingSlipService;
import com.acme.freeplace.booking.mapping.ParkingSlipMapper;
import com.acme.freeplace.booking.resource.CreateParkingSlipResource;
import com.acme.freeplace.booking.resource.ParkingSlipResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/parkingSlip", produces = "application/json")
public class ParkingSlipController {

    private final ParkingSlipService parkingSlipService;

    private final ParkingSlipMapper mapper;


    public ParkingSlipController(ParkingSlipService parkingSlipService, ParkingSlipMapper mapper) {
        this.parkingSlipService = parkingSlipService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<ParkingSlipResource> GetAllParkingSlip(Pageable pageable){
        return mapper.modelListPage(parkingSlipService.GetAll(),pageable);
    }

    @GetMapping("{parkingSlipId}")
    public ParkingSlipResource GetParkingSlipById(@PathVariable Long parkingSlipId){
        return mapper.toResource(parkingSlipService.GetById(parkingSlipId));
    }

    @PostMapping
    public ResponseEntity<ParkingSlipResource> CreatePakingSlip(@RequestBody CreateParkingSlipResource resource){
        return new ResponseEntity<>(mapper.toResource(parkingSlipService.Create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @DeleteMapping("{parkingSlipId}")
    public ResponseEntity<?> DeleteParkingSlip(@PathVariable Long pakingSlipId){
        return parkingSlipService.Delete(pakingSlipId);
    }

}
