package com.acme.freeplace.parkingLots.domain.model.entity;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
  
    @ManyToOne
    @JoinColumn(name = "owner", nullable = false)
    private Owner owner;

    private Integer spaceAvailable;

    private Integer spaceFree;

    private Integer cost;
}
