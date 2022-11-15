//Put here the entity mappers
package com.acme.freeplace.parkingLots.mapping;

<<<<<<< Updated upstream
=======
import org.springframework.context.annotation.Bean;
>>>>>>> Stashed changes
import org.springframework.context.annotation.Configuration;

@Configuration("parkingLotMappingConfiguration")
public class MappingConfiguration {
<<<<<<< Updated upstream
=======

    @Bean
    public ParkingLotMapper parkingLotMapper() {
        return new ParkingLotMapper();
    }

    @Bean
    public OwnerMapper ownerCompanyMapper(){
        return new OwnerMapper();
    }
>>>>>>> Stashed changes
}
