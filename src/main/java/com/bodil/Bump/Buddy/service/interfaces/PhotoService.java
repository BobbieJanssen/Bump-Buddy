package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {
    List<Photo> getAllPhotos();
    Optional<Photo> getPhotoById(Long id);
    List<Photo> getPhotosByAlbumId(Long albumId);
    Photo uploadPhoto(Photo photo);
    Photo updatePhoto(Long id, Photo photo);
    Photo updatePhotoNote(Long photoId, String note);
    void deletePhoto(Long id);
}
