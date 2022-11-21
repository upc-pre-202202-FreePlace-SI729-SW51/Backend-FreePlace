package com.acme.freeplace.parkingLots.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResource {


    private Long id;

    private String nameCompany;


    private String address;

    private String  description;


    private String contact;

    private String ownerType;



}
