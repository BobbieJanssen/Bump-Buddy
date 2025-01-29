package com.bodil.Bump.Buddy.repository.interfaces;

import com.bodil.Bump.Buddy.model.Pregnancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PregnancyRepository extends JpaRepository<Pregnancy, Long> {
}
