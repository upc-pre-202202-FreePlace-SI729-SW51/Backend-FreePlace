package com.acme.freeplace.parkingLots.resource;


import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotResource {

    private Long id;

    private String addrees;

    private Integer spaceFree;

    private Integer spaceAvailable;

    private String companyName;
}
