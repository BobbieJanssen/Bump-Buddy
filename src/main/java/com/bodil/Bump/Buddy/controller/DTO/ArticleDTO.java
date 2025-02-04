package com.bodil.Bump.Buddy.controller.DTO;

import java.time.LocalDate;

public class ArticleDTO {
    private String title;
    private String content;
    private int visibleAtWeek;
    private LocalDate createdAt;
    private LocalDate uploadedAt;

    // Constructor, getters and setters

    public ArticleDTO(String title, String content, int visibleAtWeek, LocalDate createdAt, LocalDate uploadedAt) {
        this.title = title;
        this.content = content;
        this.visibleAtWeek = visibleAtWeek;
        this.createdAt = createdAt;
        this.uploadedAt = uploadedAt;
    }

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
