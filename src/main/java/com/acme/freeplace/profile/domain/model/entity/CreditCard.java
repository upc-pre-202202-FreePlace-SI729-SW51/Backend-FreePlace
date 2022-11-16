package com.acme.freeplace.profile.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "credit_Card")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotBlank
    private String type;

    @NotNull
    @NotBlank
    private String cardNumber;


    private Date dateExpiration;

    @NotNull
    @NotBlank
    private String cvi;

}
