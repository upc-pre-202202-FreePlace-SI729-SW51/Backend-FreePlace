package com.acme.freeplace.booking.resource;


import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateParkingSlipResource {

    @NotNull
    @NotBlank
    private Long reservationId;

    @NotNull
    @NotBlank
    private Reservation reservation;

    @NotNull
    @NotBlank
    private Date entryTime;


    private Date exitTime;


    private Number totalCost;
}
