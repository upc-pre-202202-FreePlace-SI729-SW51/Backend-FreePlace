package com.acme.freeplace.booking.resource;

import com.acme.freeplace.booking.domain.model.entity.Reservation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class UpdateReviewResource {

    private Long id;

    @NotNull
    @NotBlank
    private Reservation reservation;

    @NotNull
    @NotBlank
    private String comment;

    @NotNull
    @NotBlank
    private Long stars;

}
