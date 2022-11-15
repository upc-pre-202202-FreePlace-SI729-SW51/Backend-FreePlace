package com.acme.freeplace.profile.resource;

import com.acme.freeplace.profile.domain.model.entity.CreditCard;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class DriverResource {

    private Long id;

    private CreditCard creditCard;

    private String fullName;

    private String contact;

    private String vehicleNumber;
}
