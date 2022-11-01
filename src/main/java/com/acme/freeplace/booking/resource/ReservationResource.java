package com.acme.freeplace.booking.resource;

import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResource {


    private Long id;

    private Driver driver;

    private ParkingLot parkingLot;

    private Date startTime;

    private Date durationMinutes;

    private Date bookingDate;
}
