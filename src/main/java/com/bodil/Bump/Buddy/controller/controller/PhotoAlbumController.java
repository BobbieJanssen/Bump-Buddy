package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.controller.DTO.PhotoAlbumDTO;
import com.bodil.Bump.Buddy.model.PhotoAlbum;
import com.bodil.Bump.Buddy.controller.mapper.PhotoAlbumMapper;
import com.bodil.Bump.Buddy.service.interfaces.PhotoAlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/photoalbums")
public class PhotoAlbumController {
    private final PhotoAlbumService photoAlbumService;
    private final PhotoAlbumMapper photoAlbumMapper;

    public PhotoAlbumController(PhotoAlbumService photoAlbumService, PhotoAlbumMapper photoAlbumMapper) {
        this.photoAlbumService = photoAlbumService;
        this.photoAlbumMapper = photoAlbumMapper;
    }

    @GetMapping
    public List<PhotoAlbumDTO> getAllPhotoAlbums() {
        return photoAlbumService.getAllPhotoAlbums().stream()
                .map(PhotoAlbumMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoAlbumDTO> getPhotoAlbumById(@PathVariable Long id) {
        return photoAlbumService.getPhotoAlbumById(id)
                .map(PhotoAlbumMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<PhotoAlbumDTO> getPhotoAlbumByUserId(@PathVariable Long userId) {
        return photoAlbumService.getPhotoAlbumByUserId(userId).stream()
                .map(PhotoAlbumMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}/note")
    public ResponseEntity<PhotoAlbumDTO> updatePhotoAlbumNote(@PathVariable Long id, @RequestBody String note) {
        PhotoAlbum updatedAlbum = photoAlbumService.updatePhotoAlbumNote(id, note);
        return ResponseEntity.ok(PhotoAlbumMapper.toDTO(updatedAlbum));
    }

    @PostMapping
    public ResponseEntity<PhotoAlbumDTO> createPhotoAlbum(@RequestBody PhotoAlbumDTO photoAlbumDTO) {
        PhotoAlbum photoAlbum = PhotoAlbumMapper.toEntity(photoAlbumDTO);
        PhotoAlbum createdAlbum = photoAlbumService.createPhotoAlbum(photoAlbum);
        return ResponseEntity.ok(PhotoAlbumMapper.toDTO(createdAlbum));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoAlbumDTO> updatePhotoAlbum(@PathVariable Long id, @RequestBody PhotoAlbumDTO photoAlbumDTO) {
        PhotoAlbum photoAlbum = PhotoAlbumMapper.toEntity(photoAlbumDTO);
        PhotoAlbum updatedAlbum = photoAlbumService.updatePhotoAlbum(id, photoAlbum);
        return ResponseEntity.ok(PhotoAlbumMapper.toDTO(updatedAlbum));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhotoAlbum(@PathVariable Long id) {
        photoAlbumService.deletePhotoAlbum(id);
        return ResponseEntity.noContent().build();
    }

}
