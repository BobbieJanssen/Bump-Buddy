package com.bodil.Bump.Buddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description;
    private boolean isCompleted;

    @ManyToOne
    @JoinColumn(name = "checklist_id")
    private Checklist checklist;

    public Task() {}
    // Getters en setters


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

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public void setIsCompleted(boolean b) {
    }
}
