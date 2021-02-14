package com.avinty.hr.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
@Getter
public class ActiveRequest {
    @NonNull
    private boolean active;
}
