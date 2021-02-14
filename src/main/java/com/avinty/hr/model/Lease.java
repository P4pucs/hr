package com.avinty.hr.model;

import com.avinty.hr.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "lease")
public class Lease extends BaseEntity {

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "car_id", referencedColumnName = "id")
    @ManyToOne
    private Car car;

    @JoinColumn(name = "start_city", referencedColumnName = "id")
    @ManyToOne
    private City startCity;

    @JoinColumn(name = "end_city", referencedColumnName = "id")
    @ManyToOne
    private City endCity;

    @CreationTimestamp
    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "start_date")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    @Column(name = "end_date")
    private LocalDateTime endDate;

    private boolean active = true;


    public Lease(User user, Car car, City startCity, City endCity) {
        this.user = user;
        this.car = car;
        this.startCity = startCity;
        this.endCity = endCity;
    }
}
