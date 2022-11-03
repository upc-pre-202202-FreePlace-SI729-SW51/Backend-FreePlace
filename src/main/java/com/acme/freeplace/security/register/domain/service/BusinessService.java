package com.acme.freeplace.security.register.domain.service;

import com.acme.freeplace.security.register.domain.model.Business;

public interface BusinessService {
    Business getById(Long id);
    Business create(Business business);

    Business getAccount(String email, String password);
}
