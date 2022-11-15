package com.acme.freeplace.profile.domain.service;

import com.acme.freeplace.profile.domain.model.entity.CreditCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CreditCardService {

    List<CreditCard> getAll();
    Page<CreditCard> getAll(Pageable pageable);
    CreditCard getById(Long creditCardId);
    CreditCard create(CreditCard creditCard);
    CreditCard update(Long creditCardId, CreditCard request);
    ResponseEntity<?> delete(Long creditCardId);

}
