//Put here the entity mappers
package com.acme.freeplace.booking.mapping;

import com.acme.freeplace.profile.mapping.DriverMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("bookingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ReservationMapper reservationMapper() {
        return new ReservationMapper();
    }
}
