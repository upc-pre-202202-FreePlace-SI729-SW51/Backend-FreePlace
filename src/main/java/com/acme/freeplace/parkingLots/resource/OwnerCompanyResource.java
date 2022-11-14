package com.acme.freeplace.parkingLots.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OwnerCompanyResource {


    private Long id;


    private String address;


    private Integer spaceFree;

    private Integer spaceAvailable;

    private String companyName;
}
