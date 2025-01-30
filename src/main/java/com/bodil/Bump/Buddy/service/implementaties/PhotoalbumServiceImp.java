package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Photoalbum;
import com.bodil.Bump.Buddy.repository.interfaces.PhotoalbumRepository;
import com.bodil.Bump.Buddy.service.interfaces.PhotoalbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhotoalbumServiceImp implements PhotoalbumService {
    private final PhotoalbumRepository photoalbumRepository;

    public PhotoalbumServiceImp(PhotoalbumRepository photoalbumRepository) {
        this.photoalbumRepository = photoalbumRepository;
    }

    @Override
    public List<Photoalbum> getAllPhotoalbums() {
        return photoalbumRepository.findAll();
    }

    @Override
    public Optional<Photoalbum> getPhotoalbumById(long id) {
        return photoalbumRepository.findById(id);
    }

    @Override
    public List<Photoalbum> findAllByUserId(long userId) {
        return photoalbumRepository.findAllByUserId(userId);
    }

    @Override
    public Photoalbum createPhotoalbum(Photoalbum photoalbum) {
        return photoalbumRepository.save(photoalbum);
    }

    @Override
    public Photoalbum updatePhotoalbum(long id, Photoalbum photoalbum) {
        if (photoalbumRepository.existsById(id)) {
            return photoalbumRepository.save(photoalbum);
        } else {
            throw new RuntimeException("Photoalbum not found");
        }
    }

    @Override
    public void deletePhotoalbum(long id) {
        photoalbumRepository.deleteById(id);
    }
}
