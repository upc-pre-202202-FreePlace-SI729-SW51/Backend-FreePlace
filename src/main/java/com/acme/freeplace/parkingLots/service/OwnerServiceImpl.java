package com.acme.freeplace.parkingLots.service;

import com.acme.freeplace.parkingLots.domain.model.entity.Owner;
import com.acme.freeplace.parkingLots.domain.persistence.OwnerRepository;
import com.acme.freeplace.parkingLots.domain.service.OwnerService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private static final String ENTITY = "OwnerCompany";


    private final OwnerRepository ownerRepository;


    private final Validator validator;

    public OwnerServiceImpl(OwnerRepository ownerRepository, Validator validator) {
        this.ownerRepository = ownerRepository;
        this.validator = validator;
    }


    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }

    @Override
    public Page<Owner> getAll(Pageable pageable) {
        return ownerRepository.findAll(pageable);
    }

    @Override
    public Owner getById(Long ownerCompanyId) {
        return ownerRepository.findById(ownerCompanyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ownerCompanyId));    }

    @Override
    public Owner create(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Long ownerCompanyId, Owner request) {

        return ownerRepository.findById(ownerCompanyId).map(owner ->
                        ownerRepository.save(
                                owner.withNameCompany(request.getNameCompany())
                                        .withAddress(request.getAddress())
                                        .withDescription(request.getDescription())
                                        .withContact(request.getContact())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ownerCompanyId));
    }

    @Override
    public ResponseEntity<?> delete(Long ownerCompanyId) {
        return ownerRepository.findById(ownerCompanyId).map(owner -> {
            ownerRepository.delete(owner);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ownerCompanyId));
    }
}
