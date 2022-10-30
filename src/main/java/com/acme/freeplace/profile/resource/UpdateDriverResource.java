package com.acme.freeplace.profile.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdateDriverResource {

    private Long id;


    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String vehicleNumber;

    private Date registrationDate;

    @NotNull
    @NotBlank
    @Size(max = 60)
    @Column(unique = true)
    private String contact;

    private Integer crediCard;

    private Integer NumberCard;
}
