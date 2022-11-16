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

    private Long reservationId;

    private Date entryTime;

    private Date exitTime;

    private Number totalCost;
}
