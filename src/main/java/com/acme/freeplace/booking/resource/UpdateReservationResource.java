package com.acme.freeplace.booking.resource;

import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
public class UpdateReservationResource {

    private Long id;

    @NotNull
    @NotBlank
    private Long driverId;

    @NotNull
    @NotBlank
    private Long parkingLotId;
    @NotNull
    @NotBlank
    private Date startTime;
    @NotNull
    @NotBlank
    private Date durationMinutes;
    @NotNull
    @NotBlank
    private Date bookingDate;
}
