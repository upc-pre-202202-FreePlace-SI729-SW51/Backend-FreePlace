//Put here the entity mappers
package com.acme.freeplace.parkingLots.mapping;

import com.acme.freeplace.profile.mapping.DriverMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("parkingLotMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ParkingLotMapper parkingLotMapper() {
        return new ParkingLotMapper();
    }
}
