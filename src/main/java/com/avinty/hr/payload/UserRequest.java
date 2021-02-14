package com.avinty.hr.payload;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Getter
@NoArgsConstructor
public class UserRequest {
    @NonNull
    private String fullName;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String email;
}
