package com.acme.freeplace.booking.resource;

import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationResource {

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "driver_id", nullable = false)
    @JsonIgnore
    private Driver driver;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "parkingLot_id", nullable = false)
    @JsonIgnore
    private ParkingLot parkingLot;

    private Date startTime;

    private Date durationMinutes;

    private Date bookingDate;
}
