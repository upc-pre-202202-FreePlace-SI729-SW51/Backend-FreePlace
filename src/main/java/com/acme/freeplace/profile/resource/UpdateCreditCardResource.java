package com.acme.freeplace.profile.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UpdateCreditCardResource {

    private Long id;
    @NotBlank
    @NotNull
    private String type;
    @NotBlank
    @NotNull
    private String cardNumber;
    @NotBlank
    @NotNull
    private Date dateExpiration;
    @NotBlank
    @NotNull
    private String cvi;
}
