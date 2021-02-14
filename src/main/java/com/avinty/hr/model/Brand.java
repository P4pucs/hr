package com.avinty.hr.model;

import com.avinty.hr.model.base.NameBaseEntity;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
public class Brand extends NameBaseEntity {
    public Brand(String name) {
        super(name);
    }

    public Brand() { }
}
