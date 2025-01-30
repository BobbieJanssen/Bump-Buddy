package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.User;
import com.bodil.Bump.Buddy.repository.interfaces.UserRepository;
import com.bodil.Bump.Buddy.service.interfaces.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    //check of dit klopt
    @Override
    public User updateUser(long id, User user) {
        if (userRepository.existsById(id)) {
            return userRepository.save(user);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUser(long id) {

        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
