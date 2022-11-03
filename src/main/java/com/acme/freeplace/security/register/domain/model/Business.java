package com.acme.freeplace.security.register.domain.model;

import com.acme.freeplace.shared.domain.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "businesses")
public class Business extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String subscription;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @Digits(integer = 16, fraction = 0)
    private int creditCard;
    @NotNull
    @Digits(integer = 3, fraction = 0)
    private int cvv;
    @NotNull
    @NotBlank
    private String type;
}
