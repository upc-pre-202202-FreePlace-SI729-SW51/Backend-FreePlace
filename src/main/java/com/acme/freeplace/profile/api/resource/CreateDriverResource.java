package com.acme.freeplace.profile.api.resource;

import com.acme.freeplace.profile.domain.model.entity.CreditCard;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
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

    private Long creditCardId;

    private String fullName;

    private String contact;

    private String vehicleNumber;

    private String username;

    private String email;

    private String password;

}
