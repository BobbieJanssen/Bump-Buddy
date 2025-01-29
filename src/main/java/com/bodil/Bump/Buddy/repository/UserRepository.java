package com.bodil.Bump.Buddy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bodil.Bump.Buddy.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

