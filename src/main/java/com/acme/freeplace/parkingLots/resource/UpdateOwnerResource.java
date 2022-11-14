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
    private String addrees;

    @NotNull
    @NotBlank
    private Integer spaceFree;
    @NotNull
    @NotBlank
    private Integer spaceAvailable;
    @NotNull
    @NotBlank
    private String companyName;
}
