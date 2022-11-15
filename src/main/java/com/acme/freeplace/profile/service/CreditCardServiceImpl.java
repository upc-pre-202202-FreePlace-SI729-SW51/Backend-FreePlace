package com.acme.freeplace.profile.service;

import com.acme.freeplace.profile.domain.model.entity.CreditCard;
import com.acme.freeplace.profile.domain.persistence.CreditCardRepository;
import com.acme.freeplace.profile.domain.service.CreditCardService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private static final String ENTITY = "CreditCard";

    private final CreditCardRepository creditCardRepository;

    public CreditCardServiceImpl(CreditCardRepository creditCardRepository) {
        this.creditCardRepository = creditCardRepository;
    }


    @Override
    public List<CreditCard> getAll() {
        return creditCardRepository.findAll();
    }

    @Override
    public Page<CreditCard> getAll(Pageable pageable) {
        return creditCardRepository.findAll(pageable);
    }

    @Override
    public CreditCard getById(Long creditCardId) {
        return creditCardRepository.findById(creditCardId)
                .orElseThrow(()->new ResourceNotFoundException(ENTITY,creditCardId)) ;
    }

    @Override
    public CreditCard create(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    @Override
    public CreditCard update(Long creditCardId, CreditCard request) {

        return creditCardRepository.findById(creditCardId).map(creditCard ->
                        creditCardRepository.save(
                                creditCard.withType(request.getType())
                                        .withCardNumber(request.getCardNumber())
                                        .withDateExpiration(request.getDateExpiration())
                                        .withCVI(request.getCVI())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, creditCardId));
    }

    @Override
    public ResponseEntity<?> delete(Long creditCardId) {

        return creditCardRepository.findById(creditCardId).map(creditCard -> {
            creditCardRepository.delete(creditCard);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, creditCardId));
    }
}
