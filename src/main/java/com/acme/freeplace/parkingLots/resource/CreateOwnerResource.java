package com.acme.freeplace.parkingLots.resource;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateOwnerResource {

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
