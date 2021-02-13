package com.avinty.hr.repository;

import com.avinty.hr.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Async
    @Query(value = "SELECT c FROM Car c " +
            "ORDER BY c.licencePlate ASC")
    List<Car> findAllCars();

    @Async
    @Query(value = "SELECT c FROM Car c where UPPER(c.licencePlate) " +
            "LIKE UPPER(concat('%', :licensp,'%')) " +
            "ORDER BY c.licencePlate ASC")
    List<Car> findCarsByLicencePlate(@Param("licensp") String licensp);
}
