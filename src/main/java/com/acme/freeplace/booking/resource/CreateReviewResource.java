package com.acme.freeplace.booking.resource;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateReviewResource {
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name = "reservation_id",nullable = false)
    @JsonIgnore
    private Reservation reservation;

    private String coment;
    private Long strars;
}
