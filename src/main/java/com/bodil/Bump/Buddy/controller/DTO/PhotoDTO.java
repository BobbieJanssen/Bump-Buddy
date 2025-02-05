package com.bodil.Bump.Buddy.controller.DTO;

import java.time.LocalDate;

public class PhotoDTO {
    private Long id;
    private String filepath;
    private String note;
    private LocalDate uploadedAt;
    private Long albumId;

    public PhotoDTO() {}

    public PhotoDTO(Long id, String filepath, String note, LocalDate uploadedAt, Long albumId) {
        this.id = id;
        this.filepath = filepath;
        this.note = note;
        this.uploadedAt = uploadedAt;
        this.albumId = albumId;
    }

    // Getters en setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDate uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }
}

