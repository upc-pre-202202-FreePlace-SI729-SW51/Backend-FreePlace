package com.acme.freeplace.booking.resource;


import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateParkingSlipResource {

    @OneToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name = "reservation_id",nullable = false)
    @JsonIgnore
    private Reservation reservation;

    private Date entryTime;

    private Date entryExit;

    private Number totalCost;
}
