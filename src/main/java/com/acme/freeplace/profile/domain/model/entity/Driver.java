package com.acme.freeplace.profile.domain.model.entity;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driver")
public class Driver{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "credit_card", nullable = false)
    private CreditCard creditCard;

    @NotNull
    @NotBlank
    private String fullName;


    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String contact;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String vehicleNumber;

}
