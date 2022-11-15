package com.acme.freeplace.parkingLots.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResource {


    private Long id;


    private String address;


    private Integer spaceFree;

    private Integer spaceAvailable;

    private String companyName;


    private String ownerType;

}
