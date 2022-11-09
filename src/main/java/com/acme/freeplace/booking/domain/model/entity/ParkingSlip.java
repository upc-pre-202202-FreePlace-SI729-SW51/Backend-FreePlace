package com.acme.freeplace.booking.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parking_slip")
public class ParkingSlip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "reservation_id",nullable = false)
    @JsonIgnore
    private Reservation reservation;

    @NotNull
    @NotBlank
    private Date entryTime;

    @NotNull
    @NotBlank
    private Date entryExit;

    @NotNull
    @NotBlank
    private Number totalCost;


}
