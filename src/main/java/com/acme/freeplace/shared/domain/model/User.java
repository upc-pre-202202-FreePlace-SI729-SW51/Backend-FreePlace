package com.acme.freeplace.shared.domain.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class User {
    @Column(name = "email", nullable = false)
    @NotNull
    @NotBlank
    @Email
    private String email;
    @Column(name = "password", nullable = false)
    @NotNull
    @NotBlank
    private String password;
    @Column(name = "phone", nullable = false)
    @Digits(integer = 9, fraction = 0)
    @NotNull
    private int phone;
}
