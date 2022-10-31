package com.acme.freeplace.parkingLots.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class UpdateParkingLotResource {

    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 120)
    @Column(unique = true)
    private String addrees;

    private Integer spaceFree;

    private Integer spaceAvailable;

    @NotNull
    @NotBlank
    @Size(max = 120)
    @Column(unique = true)
    private String companyName;
}
