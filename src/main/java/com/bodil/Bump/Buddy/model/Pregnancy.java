package com.bodil.Bump.Buddy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pregnancies")
public class Pregnancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private java.time.LocalDate dueDate;


    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user; // Samenstelling: een pregnancy hoort bij 1 user

    public Pregnancy() {}

    // Getters en setters


    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
