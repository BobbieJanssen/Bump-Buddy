package com.bodil.Bump.Buddy.repository;

import com.bodil.Bump.Buddy.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipRepository extends JpaRepository<Tip, Integer> {
}
