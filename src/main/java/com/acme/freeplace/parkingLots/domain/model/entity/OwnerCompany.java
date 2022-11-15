package com.acme.freeplace.parkingLots.domain.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owner_company")
public class OwnerCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String nameCompany;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    @NotBlank
    private String  description;

    @NotNull
    @NotBlank
    @Size(max = 9)
    private String contact;



}
