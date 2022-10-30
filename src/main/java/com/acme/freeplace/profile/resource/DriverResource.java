package com.acme.freeplace.profile.resource;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DriverResource {

    private Long id;

    private String vehicleNumber;

    private Date registrationDate;

    private String contact;

    private Integer crediCard;

    private Integer NumberCard;
}
