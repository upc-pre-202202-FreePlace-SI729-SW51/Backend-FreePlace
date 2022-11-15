package com.acme.freeplace.parkingLots.resource;


import com.acme.freeplace.parkingLots.domain.model.entity.Owner;
import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotResource {

    private Long id;
  
    private Long owner;

    private Integer spaceAvailable;

    private Integer spaceFree;

    private Integer cost;
}
