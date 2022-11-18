package com.acme.freeplace.profile.api.resource;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UpdateCreditCardResource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String type;


    private String cardNumber;


    private Date dateExpiration;


    private String cvi;
}
