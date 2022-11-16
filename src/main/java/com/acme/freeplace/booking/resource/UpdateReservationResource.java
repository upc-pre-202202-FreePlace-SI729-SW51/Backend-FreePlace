package com.acme.freeplace.booking.resource;


import lombok.Getter;
import lombok.Setter;


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
    private Date durationMinutes;
    @NotNull
    @NotBlank
    private Date bookingDate;

    @NotNull
    @NotBlank
    private Date startTime;
}
