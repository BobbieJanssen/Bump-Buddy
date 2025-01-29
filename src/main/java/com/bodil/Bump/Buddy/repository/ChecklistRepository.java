package com.bodil.Bump.Buddy.repository;

import com.bodil.Bump.Buddy.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Integer> {
}
