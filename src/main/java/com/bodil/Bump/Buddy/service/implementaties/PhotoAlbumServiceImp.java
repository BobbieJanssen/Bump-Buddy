package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.PhotoAlbum;
import com.bodil.Bump.Buddy.repository.interfaces.PhotoAlbumRepository;
import com.bodil.Bump.Buddy.service.interfaces.PhotoAlbumService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoAlbumServiceImp implements PhotoAlbumService {
    private final PhotoAlbumRepository photoAlbumRepository;

    public PhotoAlbumServiceImp(PhotoAlbumRepository photoAlbumRepository) {
        this.photoAlbumRepository = photoAlbumRepository;
    }

    @Override
    public List<PhotoAlbum> getAllPhotoAlbums() {
        return photoAlbumRepository.findAll();
    }

    @Override
    public Optional<PhotoAlbum> getPhotoAlbumById(Long id) {
        return photoAlbumRepository.findById(id);
    }

    @Override
    public List<PhotoAlbum> getPhotoAlbumByUserId(Long userId) {
        return photoAlbumRepository.findAllByUserId(userId);
    }

    @Override
    public PhotoAlbum updatePhotoAlbumNote(Long albumId, String note) {
        PhotoAlbum album = photoAlbumRepository.findById(albumId)
                .orElseThrow(() -> new EntityNotFoundException("Album not found"));
        album.setNote(note);
        return photoAlbumRepository.save(album);
    }

    @Override
    public PhotoAlbum createPhotoAlbum(PhotoAlbum photoAlbum) {
        return photoAlbumRepository.save(photoAlbum);
    }

    @Override
    public PhotoAlbum updatePhotoAlbum(Long id, PhotoAlbum photoAlbum) {
        if (photoAlbumRepository.existsById(id)) {
            return photoAlbumRepository.save(photoAlbum);
        } else {
            throw new RuntimeException("Album not found");
        }
    }

    @Override
    public void deletePhotoAlbum(Long id) {
        photoAlbumRepository.deleteById(id);
    }
}
