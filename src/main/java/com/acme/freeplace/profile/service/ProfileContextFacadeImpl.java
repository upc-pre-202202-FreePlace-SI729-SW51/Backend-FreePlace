package com.acme.freeplace.profile.service;

import com.acme.freeplace.profile.api.internal.ProfileContextFacade;
import com.acme.freeplace.profile.domain.service.CreditCardService;

public class ProfileContextFacadeImpl implements ProfileContextFacade {

    private final CreditCardService creditCardService;

    public ProfileContextFacadeImpl(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @Override
    public int GetTotalCreditCards() {
        return creditCardService.getAll().size();
    }
}
