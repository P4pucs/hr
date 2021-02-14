package com.avinty.hr.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
@Getter
public class UserRequest {
    @NonNull
    private String fullName;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String email;
}
