package com.acme.freeplace.booking.domain.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch=FetchType.EAGER, optional = false)
    @JoinColumn(name = "reservation_id",nullable = false)
    @JsonIgnore
    private Reservation reservation;

    @NonNull
    @NotBlank
    private String comment;


    private Integer stars;

}
