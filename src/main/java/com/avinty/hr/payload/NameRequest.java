package com.avinty.hr.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
@Getter
public class NameRequest {

    @NonNull
    private String name;
}
