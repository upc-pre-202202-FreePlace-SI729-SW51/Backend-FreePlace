package com.acme.freeplace.parkingLots.domain.service;

import com.acme.freeplace.parkingLots.domain.model.entity.OwnerCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerCompanyService {

    List<OwnerCompany> getAll();
    Page<OwnerCompany> getAll(Pageable pageable);
    OwnerCompany getById(Long ownerCompanyId);
    OwnerCompany create(OwnerCompany ownerCompany);
    OwnerCompany update(Long ownerCompanyId, OwnerCompany request);
    ResponseEntity<?> delete(Long ownerCompanyId);


}
