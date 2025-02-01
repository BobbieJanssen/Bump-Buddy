package com.bodil.Bump.Buddy.repository.interfaces;

import com.bodil.Bump.Buddy.model.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipRepository extends JpaRepository<Tip, Long> {
    List<Tip> findByVisibleAtWeek(int week);
}
