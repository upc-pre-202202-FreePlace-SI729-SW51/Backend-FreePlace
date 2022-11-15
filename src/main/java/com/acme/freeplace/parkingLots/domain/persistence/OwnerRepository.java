package com.acme.freeplace.parkingLots.domain.persistence;

import com.acme.freeplace.parkingLots.domain.model.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
