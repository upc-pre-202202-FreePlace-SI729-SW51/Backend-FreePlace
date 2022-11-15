package com.acme.freeplace.parkingLots.domain.service;

import com.acme.freeplace.parkingLots.domain.model.entity.Owner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OwnerService {

    List<Owner> getAll();
    Page<Owner> getAll(Pageable pageable);
    Owner getById(Long ownerCompanyId);
    Owner create(Owner owner);
    Owner update(Long ownerCompanyId, Owner request);
    ResponseEntity<?> delete(Long ownerCompanyId);


}
