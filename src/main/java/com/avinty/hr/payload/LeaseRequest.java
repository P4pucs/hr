package com.avinty.hr.payload;

import com.avinty.hr.model.Car;
import com.avinty.hr.model.City;
import com.avinty.hr.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Data
@Getter
public class LeaseRequest {
    @NonNull
    private User user;

    @NonNull
    private Car car;

    @NonNull
    private City startCity;

    @NonNull
    private City endCity;
}
