package com.bodil.Bump.Buddy.controller;

import com.bodil.Bump.Buddy.service.interfaces.AccessService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }
}
