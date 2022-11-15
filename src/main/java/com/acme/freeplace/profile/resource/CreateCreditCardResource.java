package com.acme.freeplace.profile.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateCreditCardResource {

    private String type;
    private String cardNumber;
    private Date dateExpiration;
    private String CVI;
}
