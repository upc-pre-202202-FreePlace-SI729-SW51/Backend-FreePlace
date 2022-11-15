//Put here the entity mappers
package com.acme.freeplace.booking.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("bookingMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public ReservationMapper reservationMapper() {
        return new ReservationMapper();
    }

    @Bean ParkingSlipMapper parkingSlipMapper(){return new ParkingSlipMapper();}

    @Bean
    ReviewsMapper reviewsMapper(){return new ReviewsMapper();}
}
