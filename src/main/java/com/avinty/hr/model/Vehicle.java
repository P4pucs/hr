package com.avinty.hr.model;

import com.avinty.hr.model.base.BaseEntity;
import com.avinty.hr.model.enums.Category;
import lombok.*;

import javax.persistence.*;

@NonNull
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity {

    @Column(name = "license_plate")
    private String licencePlate;

    //brand_id
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    private Brand brand;

    //colour_id
    @JoinColumn(name = "colour_id", referencedColumnName = "id")
    @ManyToOne
    private Colour colour;

    //category_id
    @Enumerated(EnumType.STRING)
    private Category category;

}
