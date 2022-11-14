package com.acme.freeplace.profile.api.rest;

import com.acme.freeplace.profile.domain.service.CreditCardService;
import com.acme.freeplace.profile.mapping.CreditCardMapper;
import com.acme.freeplace.profile.resource.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/creditCard", produces = "application/json")
public class CreditCardsController {


    private final CreditCardService creditCardService;

    private final CreditCardMapper mapper;


    public CreditCardsController(CreditCardService creditCardService, CreditCardMapper mapper) {
        this.creditCardService = creditCardService;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<CreditCardResource> getAllCreditCard(Pageable pageable) {
        return mapper.modelListPage(creditCardService.getAll(), pageable);
    }

    @GetMapping("{creditCardId}")
    public CreditCardResource getCreditCardById(@PathVariable Long creditCardId){

        return  mapper.toResource(creditCardService.getById(creditCardId));
    }

    @PostMapping
    public ResponseEntity<CreditCardResource> createCreditCard(@RequestBody CreateCreditCardResource resource) {
        return new ResponseEntity<>(mapper.toResource(creditCardService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{creditCardId}")
    public CreditCardResource updateCreditCard(@PathVariable Long creditCardId,
                                        @RequestBody UpdateCreditCardResource resource) {
        return mapper.toResource(creditCardService.update(creditCardId, mapper.toModel(resource)));
    }

    @DeleteMapping("{creditCardId}")
    public ResponseEntity<?> deleteCreditCard(@PathVariable Long creditCardId) {
        return creditCardService.delete(creditCardId);
    }
}
