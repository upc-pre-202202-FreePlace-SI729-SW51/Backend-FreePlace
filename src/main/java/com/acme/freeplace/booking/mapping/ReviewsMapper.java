package com.acme.freeplace.booking.mapping;

import com.acme.freeplace.booking.domain.model.entity.Reviews;
import com.acme.freeplace.booking.resource.CreateReviewResource;
import com.acme.freeplace.booking.resource.ReviewsResource;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ReviewsMapper {
    @Autowired
    EnhancedModelMapper mapper;

    public ReviewsResource toResource(Reviews model){return mapper.map(model,ReviewsResource.class);}

    public Reviews toModel(CreateReviewResource resource){return mapper.map(resource,Reviews.class);}

    public Page<ReviewsResource> modelListPage(List<Reviews> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList,ReviewsResource.class),pageable,modelList.size());
    }
}
