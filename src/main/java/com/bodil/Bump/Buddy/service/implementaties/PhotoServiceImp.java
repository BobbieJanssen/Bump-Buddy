package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.controller.DTO.PhotoDTO;
import com.bodil.Bump.Buddy.controller.mapper.PhotoMapper;
import com.bodil.Bump.Buddy.model.Photo;
import com.bodil.Bump.Buddy.model.PhotoAlbum;
import com.bodil.Bump.Buddy.repository.interfaces.PhotoAlbumRepository;
import com.bodil.Bump.Buddy.repository.interfaces.PhotoRepository;
import com.bodil.Bump.Buddy.service.interfaces.PhotoService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class PhotoServiceImp implements PhotoService {
    private final PhotoRepository photoRepository;
    private final PhotoAlbumRepository photoAlbumRepository;

    public PhotoServiceImp(PhotoRepository photoRepository, PhotoAlbumRepository photoAlbumRepository) {
        this.photoRepository = photoRepository;
        this.photoAlbumRepository = photoAlbumRepository;
    }

    @Override
    public List<PhotoDTO> getAllPhotos() {
        List<Photo> photos = photoRepository.findAll();
        return PhotoMapper.toDTOList(photos);
    }

    @Override
    public Optional<PhotoDTO> getPhotoById(Long id) {
        return photoRepository.findById(id).map(PhotoMapper::toDTO);
    }

    @Override
    public List<PhotoDTO> getPhotosByAlbumId(Long albumId) {
        List<Photo> photos = photoRepository.findAllByAlbumId(albumId);
        return PhotoMapper.toDTOList(photos);
    }

    @Override
    public PhotoDTO uploadPhoto(PhotoDTO photoDTO) {
        PhotoAlbum album = photoAlbumRepository.findById(photoDTO.getAlbumId())
                .orElseThrow(() -> new EntityNotFoundException("Album not found"));
        Photo photo = PhotoMapper.toEntity(photoDTO, album);
        Photo savedPhoto = photoRepository.save(photo);
        return PhotoMapper.toDTO(savedPhoto);
    }

    @Override
    public PhotoDTO updatePhoto(Long id, PhotoDTO photoDTO) {
       Photo photo = photoRepository.findById( id)
               .orElseThrow(() -> new EntityNotFoundException("Photo not found"));
       PhotoAlbum album = photoAlbumRepository.findById(photoDTO.getAlbumId())
               .orElseThrow(() -> new EntityNotFoundException("Album not found"));
       photo.setFilepath(photoDTO.getFilepath());
       photo.setNote(photoDTO.getNote());
       photo.setUploadedAt(photoDTO.getUploadedAt());
       photo.setPhotoAlbum(album);
       Photo updatedPhoto = photoRepository.save(photo);
       return PhotoMapper.toDTO(updatedPhoto);
    }

    @Override
    public PhotoDTO updatePhotoNote(Long photoId, String note) {
        Photo photo = photoRepository.findById(photoId)
                .orElseThrow(() -> new EntityNotFoundException("Photo not found"));
        photo.setNote(note);
        Photo updatedPhoto = photoRepository.save(photo);
        return PhotoMapper.toDTO(updatedPhoto);
    }

    @Override
    public void deletePhoto(Long id) {
        photoRepository.deleteById(id);
    }
}
