package com.avinty.hr.model;

import com.avinty.hr.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NonNull
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lease")
public class Lease extends BaseEntity {

    //user_id
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    //vehicle_id
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @ManyToOne
    private Car car;

    //start_city
    @JoinColumn(name = "start_city", referencedColumnName = "id")
    @ManyToOne
    private City startCity;

    //end_city
    @JoinColumn(name = "end_city", referencedColumnName = "id")
    @ManyToOne
    private City endCity;

    //start_date
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime start_date;

    //end_date
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private LocalDateTime end_date;
}
