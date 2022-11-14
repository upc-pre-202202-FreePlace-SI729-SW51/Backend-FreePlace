package com.acme.freeplace.booking.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    private Date startTime;

    private Date durationMinutes;

    private Date bookingDate;
}
