package com.avinty.hr.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SumResponse {
    @NonNull
    private Long sum;
}
