package com.acme.freeplace.profile.domain.persistence;

import com.acme.freeplace.profile.domain.model.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Driver findByVehicleNumber(String vehicleNumber);
}
