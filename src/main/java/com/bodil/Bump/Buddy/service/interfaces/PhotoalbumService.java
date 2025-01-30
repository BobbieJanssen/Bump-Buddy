package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Photoalbum;
import java.util.List;
import java.util.Optional;

public interface PhotoalbumService {
    List<Photoalbum> getAllPhotoalbums();
    Optional<Photoalbum> getPhotoalbumById(long id);
    List<Photoalbum> findAllByUserId(long userId);
    Photoalbum createPhotoalbum(Photoalbum photoalbum);
    Photoalbum updatePhotoalbum(long id, Photoalbum photoalbum);
    void deletePhotoalbum(long id);
}

