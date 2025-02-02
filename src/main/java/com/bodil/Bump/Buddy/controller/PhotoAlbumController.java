package com.bodil.Bump.Buddy.controller;

import com.bodil.Bump.Buddy.model.PhotoAlbum;
import com.bodil.Bump.Buddy.service.interfaces.PhotoAlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photoalbums")
public class PhotoAlbumController {
    private final PhotoAlbumService photoAlbumService;

    public PhotoAlbumController(PhotoAlbumService photoAlbumService) {
        this.photoAlbumService = photoAlbumService;
    }

    @GetMapping
    public List<PhotoAlbum> getAllPhotoAlbums() {
        return photoAlbumService.getAllPhotoAlbums();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoAlbum> getPhotoAlbumById(@PathVariable Long id) {
        return ResponseEntity.ok(photoAlbumService.getPhotoAlbumById(id).orElse(null));
    }

    @GetMapping("/user/{userId}")
    public List<PhotoAlbum> getPhotoAlbumByUserId(@PathVariable Long userId) {
        return photoAlbumService.getPhotoAlbumByUserId(userId);
    }

    @PutMapping("/{id}/note")
    public ResponseEntity<PhotoAlbum> updatePhotoAlbumNote(@PathVariable Long id, @RequestBody String note) {
        return ResponseEntity.ok(photoAlbumService.updatePhotoAlbumNote(id, note));
    }

    @PostMapping
    public ResponseEntity<PhotoAlbum> createPhotoAlbum(@RequestBody PhotoAlbum photoAlbum) {
        return ResponseEntity.ok(photoAlbumService.createPhotoAlbum(photoAlbum));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoAlbum> updatePhotoAlbum(@PathVariable Long id, @RequestBody PhotoAlbum photoAlbum) {
        return ResponseEntity.ok(photoAlbumService.updatePhotoAlbum(id, photoAlbum));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhotoAlbum(@PathVariable Long id) {
        photoAlbumService.deletePhotoAlbum(id);
        return ResponseEntity.noContent().build();
    }

}
