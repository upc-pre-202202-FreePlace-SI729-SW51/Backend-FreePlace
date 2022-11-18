package com.acme.freeplace.booking.resource;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResource {


    private Long id;

    private Long driverId;

    private Long parkingLotId;


    private Date durationMinutes;

    private Date bookingDate;
    private Date startTime;

}
