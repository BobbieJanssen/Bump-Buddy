package com.bodil.Bump.Buddy.model;

public class Pregnancy {
    private int id;
    private java.time.LocalDate dueDate;

    // Relatie
    private User user; // Samenstelling: een pregnancy hoort bij 1 user

    // Getters en setters
}
}
