package com.avinty.hr.model;

import com.avinty.hr.model.base.BaseEntity;
import com.avinty.hr.model.enums.Category;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "car")
public class Car extends BaseEntity {

    @Column(name = "license_plate")
    private String licencePlate;

    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    private Brand brand;

    @JoinColumn(name = "colour_id", referencedColumnName = "id")
    @ManyToOne
    private Colour colour;

    @Enumerated(EnumType.STRING)
    private Category category;

}
