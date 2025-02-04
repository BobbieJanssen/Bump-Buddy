package com.bodil.Bump.Buddy.controller.DTO;

public class AccessDTO {
    private Long id;
    private boolean status;
    private Long userId;
    private Long guestId;
    private Long photoAlbumId;

    public AccessDTO() {}

    public AccessDTO(Long id, boolean status, Long userId, Long guestId, Long photoAlbumId) {
        this.id = id;
        this.status = status;
        this.userId = userId;
        this.guestId = guestId;
        this.photoAlbumId = photoAlbumId;
    }

    // Getters en setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getGuestId() { return guestId; }
    public void setGuestId(Long guestId) { this.guestId = guestId; }

    public Long getPhotoAlbumId() { return photoAlbumId; }
    public void setPhotoAlbumId(Long photoAlbumId) { this.photoAlbumId = photoAlbumId; }
}
