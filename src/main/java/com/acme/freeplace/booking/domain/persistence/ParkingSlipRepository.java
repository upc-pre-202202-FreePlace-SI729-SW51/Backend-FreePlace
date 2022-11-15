package com.acme.freeplace.booking.domain.persistence;

import com.acme.freeplace.booking.domain.model.entity.ParkingSlip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSlipRepository extends JpaRepository<ParkingSlip, Long> {

}
