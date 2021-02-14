package com.avinty.hr.model.base;

import lombok.*;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class NameBaseEntity extends BaseEntity{
    @NonNull
    private String name;

    public NameBaseEntity(@NonNull String name) {
        this.name = name;
    }

    public NameBaseEntity() { }
}


