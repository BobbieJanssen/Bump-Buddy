package com.bodil.Bump.Buddy.model;

import java.util.List;

public class Checklist {
    private int id;
    private String title;
    private int userId;
    private boolean isTemplate;
    private java.time.LocalDate createdAt;

    // Relaties
    private List<Task> tasks; // Samenstelling: 1..* taken

    // Getters en setters
}
