package com.bodil.Bump.Buddy.controller.DTO;

import java.time.LocalDate;
import java.util.List;

public class ChecklistDTO {
    private Long id;
    private String title;
    private boolean isTemplate;
    private LocalDate createdAt;
    private Long userId;
    private List<Long> taskIds;


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

    public boolean isTemplate() {
        return isTemplate;
    }

    public void setTemplate(boolean template) {
        isTemplate = template;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<Long> taskIds) {
        this.taskIds = taskIds;
    }
}

