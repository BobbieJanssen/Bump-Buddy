package com.bodil.Bump.Buddy.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bodil.Bump.Buddy.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

