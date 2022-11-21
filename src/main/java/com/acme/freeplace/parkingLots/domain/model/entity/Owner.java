package com.acme.freeplace.parkingLots.domain.model.entity;


import com.acme.freeplace.profile.domain.model.entity.User;
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
@Table(name = "owners")
public class Owner{

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
    private String contact;

    @NotNull
    @NotBlank
    private String ownerType;



}
