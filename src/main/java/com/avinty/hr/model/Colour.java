package com.avinty.hr.model;

import com.avinty.hr.model.base.NameBaseEntity;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "colour")
public class Colour extends NameBaseEntity {
    public Colour(String name) {
        super(name);
    }

    public Colour() { }
}
