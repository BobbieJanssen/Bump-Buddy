package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(long id);
    User createUser(User user);
    User updateUser(long id, User user);
    void deleteUser(long id);
    Optional<User> findByEmail(String email);
}
