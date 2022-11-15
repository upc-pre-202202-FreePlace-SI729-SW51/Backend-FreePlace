package com.acme.freeplace.booking.resource;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationResource {


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
