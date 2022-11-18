package com.acme.freeplace.auth.resource;

import lombok.Data;

@Data
public class MessageResource {
    private String message;

    public MessageResource(String message) {
        this.message = message;
    }
}
