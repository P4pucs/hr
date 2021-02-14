package com.avinty.hr.model;

import com.avinty.hr.model.base.NameBaseEntity;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City extends NameBaseEntity {

    public City(String name) {
        super(name);
    }

    public City() { }
}
