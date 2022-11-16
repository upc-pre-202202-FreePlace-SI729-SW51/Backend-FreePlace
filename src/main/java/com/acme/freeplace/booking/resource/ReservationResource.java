package com.acme.freeplace.booking.resource;

import com.acme.freeplace.parkingLots.resource.ParkingLotResource;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.acme.freeplace.profile.resource.DriverResource;
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


    private Date durationMinutes;

    private Date bookingDate;
    private Date startTime;

}
