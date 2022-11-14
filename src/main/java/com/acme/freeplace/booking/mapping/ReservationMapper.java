package com.acme.freeplace.booking.mapping;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.acme.freeplace.booking.resource.CreateReservationResource;
import com.acme.freeplace.booking.resource.ReservationResource;
import com.acme.freeplace.booking.resource.UpdateReservationResource;
import com.acme.freeplace.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ReservationMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public ReservationResource toResource(Reservation model) {

        return mapper.map(model, ReservationResource.class);
    }

    public Reservation toModel(CreateReservationResource resource) {

        return mapper.map(resource, Reservation.class);
    }

    public Reservation toModel(UpdateReservationResource resource) {

        return mapper.map(resource, Reservation.class);
    }

    public Page<ReservationResource> modelListPage(List<Reservation> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ReservationResource.class), pageable, modelList.size());
    }


}
