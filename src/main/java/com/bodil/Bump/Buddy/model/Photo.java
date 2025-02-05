package com.bodil.Bump.Buddy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filepath;
    private String note;
    private java.time.LocalDate uploadedAt;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private PhotoAlbum photoalbum;

    public Photo() {}

    // Getters en setters


    public Long getId() {
        return id;
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

    public PhotoAlbum getPhotoAlbum() {
        return photoalbum;
    }

    public void setPhotoAlbum(PhotoAlbum photoalbum) {
        this.photoalbum = photoalbum;
    }
}
