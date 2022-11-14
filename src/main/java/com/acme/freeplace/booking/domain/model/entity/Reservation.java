package com.acme.freeplace.booking.domain.model.entity;

import com.acme.freeplace.booking.resource.CreateReservationResource;
import com.acme.freeplace.booking.resource.ReservationResource;
import com.acme.freeplace.parkingLots.domain.model.entity.ParkingLot;
import com.acme.freeplace.profile.domain.model.entity.Driver;
import com.acme.freeplace.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private Driver driver;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false)
    private ParkingLot parkingLot;

    private Date startTime;

    private Date durationMinutes;

    private Date bookingDate;

}
