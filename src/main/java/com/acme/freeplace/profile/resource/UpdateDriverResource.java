package com.acme.freeplace.profile.resource;

import com.acme.freeplace.profile.domain.model.entity.CreditCard;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdateDriverResource {

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
