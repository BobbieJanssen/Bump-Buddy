package com.bodil.Bump.Buddy.controller.DTO;

import java.time.LocalDate;

public class PregnancyDTO {
    private Long id;
    private LocalDate dueDate;
    private Long userId; 

    public PregnancyDTO() {}

    public PregnancyDTO(Long id, LocalDate dueDate, Long userId) {
        this.id = id;
        this.dueDate = dueDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}

