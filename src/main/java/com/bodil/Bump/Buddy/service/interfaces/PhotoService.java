package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.PhotoDTO;
import com.bodil.Bump.Buddy.model.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {
    List<PhotoDTO> getAllPhotos();
    Optional<PhotoDTO> getPhotoById(Long id);
    List<PhotoDTO> getPhotosByAlbumId(Long albumId);
    PhotoDTO uploadPhoto(PhotoDTO photoDTO);
    PhotoDTO updatePhoto(Long id, PhotoDTO photoDTO);
    PhotoDTO updatePhotoNote(Long photoId, String note);
    void deletePhoto(Long id);
}
