package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.AccessDTO;
import com.bodil.Bump.Buddy.model.Access;
import com.bodil.Bump.Buddy.model.PhotoAlbum;
import com.bodil.Bump.Buddy.model.User;

public class AccessMapper {
    public static AccessDTO toDTO(Access access) {
        return new AccessDTO(
                access.getId(),
                access.isStatus(),
                access.getUser().getId(),
                access.getGuest().getId(),
                access.getPhotoalbum().getId()
        );
    }

    public static Access toEntity(AccessDTO accessDTO, User user, User guest, PhotoAlbum photoAlbum) {
        Access access = new Access();
        access.setStatus(accessDTO.isStatus());
        access.setUser(user);
        access.setGuest(guest);
        access.setPhotoalbum(photoAlbum);
        return access;
    }
}

