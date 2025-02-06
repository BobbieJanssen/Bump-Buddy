package com.bodil.Bump.Buddy.controller.DTO;

public class TaskDTO {
    private Long id;
    private String description;
    private boolean isCompleted;
    private Long checklistId; // We slaan alleen de ID op, niet de hele Checklist-entiteit

    public TaskDTO() {}

    public TaskDTO(Long id, String description, boolean isCompleted, Long checklistId) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
        this.checklistId = checklistId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Long getChecklistId() {
        return checklistId;
    }

    public void setChecklistId(Long checklistId) {
        this.checklistId = checklistId;
    }
}

