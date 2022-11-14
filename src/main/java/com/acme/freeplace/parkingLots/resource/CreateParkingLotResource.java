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
