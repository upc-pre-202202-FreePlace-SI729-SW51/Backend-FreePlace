package com.acme.freeplace.security.register.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResource {
    private Long id;

    private String subscription;
    private String name;
    private int creditCard;
    private int cvv;
    private String type;

    //User
    private String email;
    private String password;
    private int phone;

}
