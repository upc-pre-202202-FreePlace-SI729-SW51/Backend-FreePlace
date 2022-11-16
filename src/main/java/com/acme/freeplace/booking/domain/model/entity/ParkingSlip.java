package com.acme.freeplace.booking.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parking_slips")
public class ParkingSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "reservation_id",nullable = false)
    @JsonIgnore
    private Reservation reservation;


    private Date entryTime;


    private Date exitTime;

    @NotNull
    @NotBlank
    private Number totalCost;


}
