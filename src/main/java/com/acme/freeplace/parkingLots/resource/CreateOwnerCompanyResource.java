package com.acme.freeplace.parkingLots.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateOwnerCompanyResource {

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



}
