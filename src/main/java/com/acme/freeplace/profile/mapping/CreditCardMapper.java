package com.acme.freeplace.profile.mapping;

import com.acme.freeplace.profile.api.resource.CreateCreditCardResource;
import com.acme.freeplace.profile.api.resource.CreditCardResource;
import com.acme.freeplace.profile.api.resource.UpdateCreditCardResource;
import com.acme.freeplace.profile.domain.model.entity.CreditCard;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class CreditCardMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public CreditCardResource toResource(CreditCard model) {
        return mapper.map(model, CreditCardResource.class);
    }

    public CreditCard toModel(CreateCreditCardResource resource) {
        return mapper.map(resource, CreditCard.class);
    }

    public CreditCard toModel(UpdateCreditCardResource resource) {
        return mapper.map(resource, CreditCard.class);
    }

    public Page<CreditCardResource> modelListPage(List<CreditCard> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, CreditCardResource.class), pageable, modelList.size());
    }
}
