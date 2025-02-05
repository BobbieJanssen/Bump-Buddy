package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.controller.DTO.PhotoDTO;
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
    public List<PhotoDTO> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoDTO> getPhotoById(@PathVariable Long id) {
        return ResponseEntity.of(photoService.getPhotoById(id));
    }

    @GetMapping("/album/{albumId}")
    public List<PhotoDTO> getPhotosByAlbumId(@PathVariable Long albumId) {
        return photoService.getPhotosByAlbumId(albumId);
    }

    @PostMapping
    public ResponseEntity<PhotoDTO> uploadPhoto(@RequestBody PhotoDTO photoDTO) {
        return ResponseEntity.ok(photoService.uploadPhoto(photoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoDTO> updatePhoto(@PathVariable Long id, @RequestBody PhotoDTO photoDTO ){
        return ResponseEntity.ok(photoService.updatePhoto(id, photoDTO));
    }

    @PutMapping("/{id}/note")
    public ResponseEntity<PhotoDTO> updatePhotoNote(@PathVariable Long id, @RequestBody String note) {
        return ResponseEntity.ok(photoService.updatePhotoNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhoto(@PathVariable Long id) {
        photoService.deletePhoto(id);
        return ResponseEntity.noContent().build();
    }
}
