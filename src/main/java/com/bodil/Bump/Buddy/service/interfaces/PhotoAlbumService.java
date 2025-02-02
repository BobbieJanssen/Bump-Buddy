package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.PhotoAlbum;
import java.util.List;
import java.util.Optional;

public interface PhotoAlbumService {
    List<PhotoAlbum> getAllPhotoAlbums();
    Optional<PhotoAlbum> getPhotoAlbumById(Long id);
    List<PhotoAlbum> getPhotoAlbumByUserId(Long userId);
    PhotoAlbum updatePhotoAlbumNote(Long albumId, String note);
    PhotoAlbum createPhotoAlbum(PhotoAlbum photoAlbum);
    PhotoAlbum updatePhotoAlbum(Long id, PhotoAlbum photoAlbum);
    void deletePhotoAlbum(Long id);
}

