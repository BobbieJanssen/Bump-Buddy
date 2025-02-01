package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {
    List<Photo> getAllPhotos();
    Optional<Photo> getPhotoById(long id);
    List<Photo> findAllByAlbumId(long albumId);
    Photo createPhoto(Photo photo);
    Photo updatePhoto(long id, Photo photo);
    Photo updatePhotoNote(long photoId, String note);
    void deletePhoto(long id);
}
