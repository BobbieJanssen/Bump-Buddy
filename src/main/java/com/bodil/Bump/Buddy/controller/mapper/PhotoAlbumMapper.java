package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.PhotoAlbumDTO;
import com.bodil.Bump.Buddy.model.PhotoAlbum;
import com.bodil.Bump.Buddy.model.User;
import org.springframework.stereotype.Component;

@Component
public class PhotoAlbumMapper {

    public static PhotoAlbumDTO toDTO(PhotoAlbum photoAlbum) {
        PhotoAlbumDTO dto = new PhotoAlbumDTO();
        dto.setId(photoAlbum.getId());
        dto.setTitle(photoAlbum.getTitle());
        dto.setNote(photoAlbum.getNote());
        dto.setCreatedAt(photoAlbum.getCreatedAt());
        if (photoAlbum.getUser() != null) {
            dto.setUserId(photoAlbum.getUser().getId());
        }
        return dto;
    }

    public static PhotoAlbum toEntity(PhotoAlbumDTO dto) {
        PhotoAlbum photoAlbum = new PhotoAlbum();
        photoAlbum.setTitle(dto.getTitle());
        photoAlbum.setNote(dto.getNote());
        photoAlbum.setCreatedAt(dto.getCreatedAt());
        // Assuming you have a User entity available
        User user = new User();
        photoAlbum.setUser(user);
        return photoAlbum;
    }
}
