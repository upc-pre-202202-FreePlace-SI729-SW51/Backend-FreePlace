package com.acme.freeplace.booking.resource;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import lombok.*;


@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class ReviewsResource {
    private Long id;

    private Long reservation;

    private String comment;

    private Long starts;
}
