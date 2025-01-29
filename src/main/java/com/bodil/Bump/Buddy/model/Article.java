package com.bodil.Bump.Buddy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;
    private int visibleAtWeek;
    private java.time.LocalDate createdAt;
    private java.time.LocalDate uploadedAt;

    public Article() {}

    // Getters en setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getVisibleAtWeek() {
        return visibleAtWeek;
    }

    public void setVisibleAtWeek(int visibleAtWeek) {
        this.visibleAtWeek = visibleAtWeek;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(LocalDate uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
