package com.example.fashionmanage.repository;
import com.example.fashionmanage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Returns the user by username
     * @author AiPV
     * @param username
     * @return User
     */
    Optional<User> findByUsername( String username);

}