package com.acme.freeplace.profile.api.resource;

import com.acme.freeplace.profile.domain.model.entity.CreditCard;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
    private Long creditCardId;

    @NotNull
    @NotBlank
    private String fullName;


    @NotNull
    @NotBlank
    private String contact;

    @NotNull
    @NotBlank
    private String vehicleNumber;
}
