package com.bodil.Bump.Buddy.model;

import java.util.List;

public class Photoalbum {
    private int id;
    private String title;
    private int userId;
    private java.time.LocalDate createdAt;

    // Relaties
    private List<Photo> photos; // Samenstelling: 0..* fotos

    // Getters en setters
}