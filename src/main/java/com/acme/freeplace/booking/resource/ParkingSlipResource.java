package com.acme.freeplace.booking.resource;


import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlipResource {

    private Long id;

    private Reservation reservation;

    private Date entryTime;

    private Date entryExit;

    private Number totalCost;
}
