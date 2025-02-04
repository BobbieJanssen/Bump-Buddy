package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.UserDTO;
import com.bodil.Bump.Buddy.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    Optional<UserDTO> getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    Optional<UserDTO> findByEmail(String email);
}
