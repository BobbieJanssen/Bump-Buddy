//Misschien pregnancy geen eigen klas maken en toevoegen bij user, zodat er bij de user staat of er sprake is van een zwangerschap
package com.bodil.Bump.Buddy.controller;

import com.bodil.Bump.Buddy.model.User;
import com.bodil.Bump.Buddy.service.implementaties.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImp userService;

    @Autowired
    public UserController(UserServiceImp userService) {
        this.userService = userService;
    }

    // Endpoint om een user op te slaan
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    // Endpoint om een user op te halen op basis van ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }
}

