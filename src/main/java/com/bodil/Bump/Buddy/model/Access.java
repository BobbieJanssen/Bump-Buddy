package com.bodil.Bump.Buddy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "access")
public class Access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private User guest;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private PhotoAlbum photoalbum;

    public Access() {}

    // Getters en setters


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getGuest() {
        return guest;
    }

    public void setGuest(User guest) {
        this.guest = guest;
    }

    public PhotoAlbum getPhotoalbum() {
        return photoalbum;
    }

    public void setPhotoalbum(PhotoAlbum photoalbum) {
        this.photoalbum = photoalbum;
    }
}
