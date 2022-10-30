package com.acme.freeplace.profile.resource;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateDriverResource {


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
