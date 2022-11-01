package com.acme.freeplace.profile.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String vehicleNumber;

    private Date registrationDate;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String contact;

    private Integer crediCard;

    private Integer numberCard;
}
