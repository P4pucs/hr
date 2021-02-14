package com.avinty.hr.repository;

import com.avinty.hr.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {

    @Async
    @Query(value = "SELECT l FROM Lease l " +
            "WHERE l.user.id = :id " +
            "AND l.active = true")
    List<Lease> getActiveLeasesOfId(@Param("id") Long id);

    @Async
    @Query(value = "SELECT l FROM Lease l " +
            "WHERE l.user.id = :id")
    List<Lease> getLeasesOfUserId(@Param("id") Long id);

    @Async
    @Query(value = "SELECT l.id FROM Lease l " +
            "WHERE l.car.id = :id " +
            "AND l.active = true")
    List<Long> getActiveCarIdById(@Param("id") Long id);
}
