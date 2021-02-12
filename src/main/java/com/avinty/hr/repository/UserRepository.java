package com.avinty.hr.repository;

import com.avinty.hr.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Async
    @Query(value = "SELECT u FROM User u where UPPER(u.fullName) " +
            "LIKE UPPER(concat('%', :fullName,'%')) " +
            "ORDER BY u.fullName ASC")
    List<User> findByName(@Param("fullName") String fullName);

}
