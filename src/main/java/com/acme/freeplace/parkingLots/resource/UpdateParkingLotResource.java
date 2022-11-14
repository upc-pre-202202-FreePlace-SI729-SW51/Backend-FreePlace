package com.acme.freeplace.parkingLots.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Getter
@Setter
public class UpdateParkingLotResource {

    @NotNull
    @NotBlank
    private Long id;
    @NotNull
    @NotBlank
    private Long owner;
    @NotNull
    @NotBlank
    private Integer spaceAvailable;
    @NotNull
    @NotBlank
    private Integer spaceFree;
    @NotNull
    @NotBlank
    private Integer cost;


}
