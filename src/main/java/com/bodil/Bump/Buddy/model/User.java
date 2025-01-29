package com.bodil.Bump.Buddy.model;

//misschien dus hier pregnancy toevoegen of een eigen klas ervoor maken -> Pas "later" in update (voor verantwoordingsdoc)
//een pregnancy controller(zwangerschapsregistratie beheren), service(verwerken van businesslogica, bv controleren of gebruiker al
// een zwangerschap heeft geregistreerd) en repo(voor opslag en ophalen uit database) maken.

import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    private String role;
    private boolean isPrivate;

    // Relaties
    private Pregnancy pregnancy; // 0..1 relatie
    private List<Photoalbum> photoalbums; // 0..* relatie
    private List<Checklist> checklists; // 0..* relatie

    // Getters en setters
}