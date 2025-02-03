package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.controller.DTO.AccessDTO;
import com.bodil.Bump.Buddy.controller.mapper.AccessMapper;
import com.bodil.Bump.Buddy.model.Access;
import com.bodil.Bump.Buddy.model.PhotoAlbum;
import com.bodil.Bump.Buddy.model.User;
import com.bodil.Bump.Buddy.repository.interfaces.AccessRepository;
import com.bodil.Bump.Buddy.service.interfaces.AccessService;
import com.bodil.Bump.Buddy.service.interfaces.PhotoAlbumService;
import com.bodil.Bump.Buddy.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccessServiceImp implements AccessService {
    private final AccessRepository accessRepository;
    private final UserService userService;
    private final PhotoAlbumService photoAlbumService;

    public AccessServiceImp(AccessRepository accessRepository, UserService userService, PhotoAlbumService photoAlbumService) {
        this.accessRepository = accessRepository;
        this.userService = userService;
        this.photoAlbumService = photoAlbumService;
    }

    @Override
    public Optional<AccessDTO> getAccessById(Long id) {
        return accessRepository.findById(id).map(AccessMapper::toDTO);
    }

    @Override
    public List<AccessDTO> getAllAccess() {
        return accessRepository.findAll().stream()
                .map(AccessMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AccessDTO createAccess(AccessDTO accessDTO) {
        User user = userService.getUserById(accessDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        User guest = userService.getUserById(accessDTO.getGuestId()).orElseThrow(() -> new RuntimeException("Guest not found"));
        PhotoAlbum photoAlbum = photoAlbumService.getPhotoAlbumById(accessDTO.getPhotoAlbumId()).orElseThrow(() -> new RuntimeException("PhotoAlbum not found"));

        Access access = AccessMapper.toEntity(accessDTO, user, guest, photoAlbum);
        Access savedAccess = accessRepository.save(access);

        return AccessMapper.toDTO(savedAccess);
    }

    @Override
    public AccessDTO updateAccess(Long id, AccessDTO accessDTO) {
        if (!accessRepository.existsById(id)) {
            throw new RuntimeException("Access not found");
        }

        User user = userService.getUserById(accessDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        User guest = userService.getUserById(accessDTO.getGuestId()).orElseThrow(() -> new RuntimeException("Guest not found"));
        PhotoAlbum photoAlbum = photoAlbumService.getPhotoAlbumById(accessDTO.getPhotoAlbumId()).orElseThrow(() -> new RuntimeException("PhotoAlbum not found"));

        Access access = AccessMapper.toEntity(accessDTO, user, guest, photoAlbum);
        Access updatedAccess = accessRepository.save(access);

        return AccessMapper.toDTO(updatedAccess);
    }

    @Override
    public void deleteAccess(Long id) {
        accessRepository.deleteById(id);
    }
}
