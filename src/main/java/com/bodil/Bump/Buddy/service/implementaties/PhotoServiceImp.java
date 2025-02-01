package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Photo;
import com.bodil.Bump.Buddy.repository.interfaces.PhotoRepository;
import com.bodil.Bump.Buddy.service.interfaces.PhotoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//logica voor foto-upload, opslag en validatie
@Service
public class PhotoServiceImp implements PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoServiceImp(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    @Override
    public Optional<Photo> getPhotoById(long id) {
        return photoRepository.findById(id);
    }

    @Override
    public List<Photo> findAllByAlbumId(long albumId) {
        return photoRepository.findAllByAlbumId(albumId);
    }

    @Override
    public Photo createPhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    @Override
    public Photo updatePhoto(long id, Photo photo) {
        if (photoRepository.existsById(id)) {
            return photoRepository.save(photo);
        } else {
            throw new RuntimeException("Photo not found");
        }
    }

    @Override
    public Photo updatePhotoNote(Long photoId, String note) {
        Photo photo = photoRepository.findById(photoId)
                .orElseThrow(() -> new EntityNotFoundException("Photo not found"));
        photo.setNote(note);
        return photoRepository.save(photo);
    }

    @Override
    public void deletePhoto(long id) {
        photoRepository.deleteById(id);
    }
}
