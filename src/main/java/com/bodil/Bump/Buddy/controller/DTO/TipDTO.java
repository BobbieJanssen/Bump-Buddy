package com.bodil.Bump.Buddy.controller.DTO;

import java.time.LocalDate;

public class TipDTO {
        private Long id;
        private String title;
        private String content;
        private int visibleAtWeek;
        private LocalDate createdAt;
        private LocalDate uploadedAt;

        // Getters en setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
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


