package com.example.fashionmanage.repository;


import com.example.fashionmanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
//    Optional<User> findByUsername(String username);
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    Optional<User> findByUsername(String username);
    @Query("SELECT u.password FROM User u WHERE u.username = ?1")
    String findPasswordByUsername( String username);

}