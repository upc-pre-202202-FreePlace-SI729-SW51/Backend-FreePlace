package com.acme.freeplace.parkingLots.service;

import com.acme.freeplace.parkingLots.domain.model.entity.OwnerCompany;
import com.acme.freeplace.parkingLots.domain.persistence.OwnerCompanyRepository;
import com.acme.freeplace.parkingLots.domain.service.OwnerCompanyService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class OwnerCompanyServiceImpl implements OwnerCompanyService {

    private static final String ENTITY = "OwnerCompany";


    private final OwnerCompanyRepository ownerCompanyRepository;


    private final Validator validator;

    public OwnerCompanyServiceImpl(OwnerCompanyRepository ownerCompanyRepository, Validator validator) {
        this.ownerCompanyRepository = ownerCompanyRepository;
        this.validator = validator;
    }


    @Override
    public List<OwnerCompany> getAll() {
        return ownerCompanyRepository.findAll();
    }

    @Override
    public Page<OwnerCompany> getAll(Pageable pageable) {
        return ownerCompanyRepository.findAll(pageable);
    }

    @Override
    public OwnerCompany getById(Long ownerCompanyId) {
        return ownerCompanyRepository.findById(ownerCompanyId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ownerCompanyId));    }

    @Override
    public OwnerCompany create(OwnerCompany ownerCompany) {
        return ownerCompanyRepository.save(ownerCompany);
    }

    @Override
    public OwnerCompany update(Long ownerCompanyId, OwnerCompany request) {

        return ownerCompanyRepository.findById(ownerCompanyId).map(ownerCompany ->
                        ownerCompanyRepository.save(
                                ownerCompany.withNameCompany(request.getNameCompany())
                                        .withAddress(request.getAddress())
                                        .withDescription(request.getDescription())
                                        .withContact(request.getContact())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ownerCompanyId));
    }

    @Override
    public ResponseEntity<?> delete(Long ownerCompanyId) {
        return ownerCompanyRepository.findById(ownerCompanyId).map(ownerCompany -> {
            ownerCompanyRepository.delete(ownerCompany);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ownerCompanyId));
    }
}
