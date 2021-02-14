package com.avinty.hr.payload;

import com.avinty.hr.model.Brand;
import com.avinty.hr.model.Colour;
import com.avinty.hr.model.enums.Category;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Data
public class CarRequest {
    @NonNull
    private String licencePlate;

    @NonNull
    private Brand brand;

    @NonNull
    private Colour colour;

    @NonNull
    private Category category;

}
