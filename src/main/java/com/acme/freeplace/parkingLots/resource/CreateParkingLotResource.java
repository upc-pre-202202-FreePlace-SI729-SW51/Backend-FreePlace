package com.acme.freeplace.parkingLots.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateParkingLotResource {


    @NotNull
    @NotBlank
    @Size(max = 120)
    @Column(unique = true)
    private String addrees;

    @NotNull
    @NotBlank
    private Integer spaceFree;

    @NotNull
    @NotBlank
    private Integer spaceAvailable;

    @NotNull
    @NotBlank
    @Size(max = 120)
    @Column(unique = true)
    private String companyName;
}
