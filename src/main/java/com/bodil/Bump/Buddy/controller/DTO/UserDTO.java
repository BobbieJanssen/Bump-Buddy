package com.bodil.Bump.Buddy.controller.DTO;

import java.util.List;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String role;
    private boolean isPrivate;
    private List<Long> photoAlbumIds;
    private List<Long> checklistIds;
    private Long pregnancyId;


    public UserDTO() {
    }

    public UserDTO(Long id, String name, String email, String role, boolean isPrivate,
                   List<Long> photoAlbumIds, List<Long> checklistIds, Long pregnancyId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.isPrivate = isPrivate;
        this.photoAlbumIds = photoAlbumIds;
        this.checklistIds = checklistIds;
        this.pregnancyId = pregnancyId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public boolean isPrivate() {
        return isPrivate;
    }


}