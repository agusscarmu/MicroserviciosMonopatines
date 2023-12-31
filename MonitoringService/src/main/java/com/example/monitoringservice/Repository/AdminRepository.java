package com.example.monitoringservice.Repository;

import com.example.monitoringservice.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface AdminRepository extends JpaRepository<User, Long> {

    @Query("SELECT a FROM User a WHERE a.username = ?1")
    Optional<Object> findByUsername(String username);

    @Modifying
    @Query("DELETE FROM User a WHERE a.username = ?1")
    void reset(String username);
}
