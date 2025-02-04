package com.bodil.Bump.Buddy.controller.mapper;


import com.bodil.Bump.Buddy.controller.DTO.UserDTO;
import com.bodil.Bump.Buddy.model.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        if(user == null) {
            return null;
        }
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.isPrivate(),
                user.getPhotoalbums() != null ? user.getPhotoalbums()
                        .stream().map(album -> album.getId()).collect(Collectors.toList()) : null,
                user.getChecklists() != null ? user.getChecklists()
                        .stream().map(checklist -> checklist.getId()).collect(Collectors.toList()) : null,
                user.getPregnancy() != null ? user.getPregnancy().getId() : null
        );
    }

    public static User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setRole(userDTO.getRole());
        user.setPrivate(userDTO.isPrivate());
        return user;
    }
}

