package com.acme.freeplace.profile.service;

import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.acme.freeplace.profile.domain.persistence.DriverRepository;
import com.acme.freeplace.profile.domain.service.DriverService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import com.acme.freeplace.shared.excepion.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class DriverServiceImpl implements DriverService {

    private static final String ENTITY = "Driver";

    private final DriverRepository driverRepository;

    private final Validator validator;

    public DriverServiceImpl(DriverRepository driverRepository, Validator validator) {
        this.driverRepository = driverRepository;
        this.validator = validator;
    }


    @Override
    public List<Driver> getAll() {
        return driverRepository.findAll();
    }

    @Override
    public Page<Driver> getAll(Pageable pageable) {
        return driverRepository.findAll(pageable);
    }

    @Override
    public Driver getById(Long driverId) {
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, driverId));

    }

    @Override
    public Driver create(Driver driver) {
        Set<ConstraintViolation<Driver>> violations = validator.validate(driver);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        Driver driverWithName = driverRepository.findByVehicleNumber(driver.getVehicleNumber());

        if(driverWithName != null)
            throw new ResourceValidationException(ENTITY,
                    "An driver with the same name already exists.");

        return driverRepository.save(driver);
    }

    @Override
    public Driver update(Long driverId, Driver request) {
        Set<ConstraintViolation<Driver>> violations = validator.validate(request);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        // Name Uniqueness validation
        Driver studentWithName = driverRepository.findByVehicleNumber(request.getVehicleNumber());

        if(studentWithName != null && !studentWithName.getId().equals(driverId))
            throw new ResourceValidationException(ENTITY,
                    "An driver with the same name already exists.");

        return driverRepository.findById(driverId).map(student ->
                        driverRepository.save(
                                student.withVehicleNumber(request.getVehicleNumber())
                                        .withRegistrationDate(request.getRegistrationDate())
                                        .withContact(request.getContact())
                                        .withCrediCard(request.getCrediCard())
                                        .withNumberCard(request.getNumberCard())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, driverId));
    }

    @Override
    public ResponseEntity<?> delete(Long driverId) {
        return driverRepository.findById(driverId).map(student -> {
            driverRepository.delete(student);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, driverId));
    }
}
