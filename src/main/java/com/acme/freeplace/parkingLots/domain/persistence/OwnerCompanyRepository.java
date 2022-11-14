package com.acme.freeplace.parkingLots.domain.persistence;

import com.acme.freeplace.parkingLots.domain.model.entity.OwnerCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerCompanyRepository extends JpaRepository<OwnerCompany,Long> {
}
