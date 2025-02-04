package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.AccessDTO;
import java.util.List;
import java.util.Optional;

public interface AccessService {
    Optional<AccessDTO> getAccessById(Long id);
    List<AccessDTO> getAllAccess();
    AccessDTO createAccess(AccessDTO accessDTO);
    AccessDTO updateAccess(Long id, AccessDTO accessDTO);
    void deleteAccess(Long id);
}
