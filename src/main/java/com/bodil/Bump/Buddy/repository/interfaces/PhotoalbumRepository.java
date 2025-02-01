package com.bodil.Bump.Buddy.repository.interfaces;

import com.bodil.Bump.Buddy.model.Photoalbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoalbumRepository extends JpaRepository<Photoalbum, Long> {
    List<Photoalbum> findAllByUserId(long userId);
}
