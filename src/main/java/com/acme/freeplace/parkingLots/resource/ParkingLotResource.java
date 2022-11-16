package com.acme.freeplace.parkingLots.resource;


import com.acme.freeplace.parkingLots.domain.model.entity.Owner;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotResource {

    private Long id;


    private Long ownerId;

    private Integer spaceAvailable;

    private Integer spaceFree;

    private Integer cost;
}
