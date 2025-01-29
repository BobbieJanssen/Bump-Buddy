package com.bodil.Bump.Buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bodil.Bump.Buddy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

