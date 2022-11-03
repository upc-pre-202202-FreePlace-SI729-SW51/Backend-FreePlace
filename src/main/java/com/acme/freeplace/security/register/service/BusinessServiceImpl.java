package com.acme.freeplace.security.register.service;

import com.acme.freeplace.security.register.domain.model.Business;
import com.acme.freeplace.security.register.domain.persistence.BusinessRepository;
import com.acme.freeplace.security.register.domain.service.BusinessService;
import com.acme.freeplace.shared.excepion.ResourceNotFoundException;
import com.acme.freeplace.shared.excepion.ResourceValidationException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;


@Service
public class BusinessServiceImpl implements BusinessService {
    private static final String ENTITY = "Business";
    private final BusinessRepository businessRepository;
    private final Validator validator;

    public BusinessServiceImpl(BusinessRepository businessRepository, Validator validator) {
        this.businessRepository = businessRepository;
        this.validator = validator;
    }

    @Override
    public Business getById(Long id) {
        return businessRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Business create(Business business) {
        Set<ConstraintViolation<Business>> violations = validator.validate(business);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);
        if (businessRepository.findByName(business.getName()) != null)
            throw new ResourceValidationException(ENTITY, "The name of the business already exists");
        if (businessRepository.findByEmail(business.getEmail()) != null)
            throw new ResourceValidationException(ENTITY, "Email already exists");
        return businessRepository.save(business);
    }
    @Override
    public Business getAccount(String email, String password){
        return businessRepository.findByEmailAndPassword(email, password);
    }
}
