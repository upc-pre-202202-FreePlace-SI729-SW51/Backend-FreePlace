package com.acme.freeplace.parkingLots.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class UpdateOwnerResource {


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
