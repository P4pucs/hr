package com.avinty.hr.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Getter
@NoArgsConstructor
public class NameRequest {

    @NonNull
    private String name;
}
