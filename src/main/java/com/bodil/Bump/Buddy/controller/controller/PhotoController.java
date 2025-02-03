package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.model.Photo;
import com.bodil.Bump.Buddy.service.interfaces.PhotoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/photos")
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping
    public Optional<Photo> getPhotoById(@PathVariable Long id) {
        return photoService.getPhotoById(id);
    }

    @GetMapping("/album/{albumId}")
    public List<Photo> getPhotosByAlbumId(@PathVariable Long albumId) {
        return photoService.getPhotosByAlbumId(albumId);
    }

    @PostMapping
    public ResponseEntity<Photo> uploadPhoto(@RequestBody Photo photo) {
        return ResponseEntity.ok(photoService.uploadPhoto(photo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Photo> updatePhoto(@PathVariable Long id, @RequestBody Photo photo ){
        return ResponseEntity.ok(photoService.updatePhoto(id, photo));
    }

    @PutMapping("/{id}/note")
    public ResponseEntity<Photo> updatePhotoNote(@PathVariable Long id, @RequestBody String note) {
        return ResponseEntity.ok(photoService.updatePhotoNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long id) {
        photoService.deletePhoto(id);
        return ResponseEntity.noContent().build();
    }
}
