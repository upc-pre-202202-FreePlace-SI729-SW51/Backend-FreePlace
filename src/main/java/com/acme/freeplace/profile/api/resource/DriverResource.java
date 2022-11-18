package com.acme.freeplace.profile.api.resource;

import lombok.*;



@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DriverResource {

    private Long id;

    private Long creditCardId;

    private String fullName;

    private String contact;

    private String vehicleNumber;
}
