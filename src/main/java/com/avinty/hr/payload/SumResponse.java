package com.avinty.hr.payload;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class SumResponse {
    @NonNull
    private Integer sum;
}
