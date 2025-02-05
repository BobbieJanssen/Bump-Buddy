package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.PhotoDTO;
import com.bodil.Bump.Buddy.model.Photo;
import com.bodil.Bump.Buddy.model.PhotoAlbum;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoMapper {

    public static PhotoDTO toDTO(Photo photo) {
        if (photo == null) {
            return null;
        }
        return new PhotoDTO(
                photo.getId(),
                photo.getFilepath(),
                photo.getNote(),
                photo.getUploadedAt(),
                photo.getPhotoAlbum() != null ? photo.getPhotoAlbum().getId() : null
        );
    }

    public static List<PhotoDTO> toDTOList(List<Photo> photos) {
        return photos.stream()
                .map(PhotoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public static Photo toEntity(PhotoDTO photoDTO, PhotoAlbum photoAlbum) {
        if (photoDTO == null) {
            return null;
        }
        Photo photo = new Photo();
        photo.setFilepath(photoDTO.getFilepath());
        photo.setNote(photoDTO.getNote());
        photo.setUploadedAt(photoDTO.getUploadedAt());
        photo.setPhotoAlbum(photoAlbum);
        return photo;
    }
}

