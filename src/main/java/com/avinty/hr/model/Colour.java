package com.avinty.hr.model;

import com.avinty.hr.model.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "colour")
public class Colour extends BaseEntity {

    @NonNull
    private String name;
}
