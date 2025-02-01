package com.bodil.Bump.Buddy.repository.interfaces;

import com.bodil.Bump.Buddy.model.PhotoAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoAlbumRepository extends JpaRepository<PhotoAlbum, Long> {
    List<PhotoAlbum> findAllByUserId(Long userId);
}
