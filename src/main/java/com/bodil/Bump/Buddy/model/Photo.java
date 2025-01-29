package com.bodil.Bump.Buddy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String filepath;
    private String note;
    private java.time.LocalDate uploadedAt;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Photoalbum photoalbum;

    public Photo() {}

    // Getters en setters

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

    public Photoalbum getPhotoalbum() {
        return photoalbum;
    }

    public void setPhotoalbum(Photoalbum photoalbum) {
        this.photoalbum = photoalbum;
    }
}
