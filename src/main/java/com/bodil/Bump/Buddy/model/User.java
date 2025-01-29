package com.bodil.Bump.Buddy.model;

//misschien dus hier pregnancy toevoegen of een eigen klas ervoor maken -> Pas "later" in update (voor verantwoordingsdoc)
//een pregnancy controller(zwangerschapsregistratie beheren), service(verwerken van businesslogica, bv controleren of gebruiker al
// een zwangerschap heeft geregistreerd) en repo(voor opslag en ophalen uit database) maken.

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;
    private String role;
    private boolean isPrivate;


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Pregnancy pregnancy; // 0..1 relatie

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Photoalbum> photoalbums; // 0..* relatie

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Checklist> checklists; // 0..* relatie

    public User() {}

    // Getters en setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Pregnancy getPregnancy() {
        return pregnancy;
    }

    public void setPregnancy(Pregnancy pregnancy) {
        this.pregnancy = pregnancy;
    }

    public List<Photoalbum> getPhotoalbums() {
        return photoalbums;
    }

    public void setPhotoalbums(List<Photoalbum> photoalbums) {
        this.photoalbums = photoalbums;
    }

    public List<Checklist> getChecklists() {
        return checklists;
    }

    public void setChecklists(List<Checklist> checklists) {
        this.checklists = checklists;
    }
}