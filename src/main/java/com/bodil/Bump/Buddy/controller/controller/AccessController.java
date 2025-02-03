package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.model.Access;
import com.bodil.Bump.Buddy.service.interfaces.AccessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/access")
public class AccessController {
    private final AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Access> getAccessById(@PathVariable Long id) {
        return ResponseEntity.ok(accessService.getAccessById(id).orElse(null));
    }

    @GetMapping
    public List<Access> getAllAccess() {
        return accessService.getAllAccess();
    }

    @PostMapping
    public ResponseEntity<Access> createAccess(@RequestBody Access access) {
        return ResponseEntity.ok(accessService.createAccess(access));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Access> updateAccess(@PathVariable Long id, @RequestBody Access access) {
        return ResponseEntity.ok(accessService.updateAccess(id, access));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccess(@PathVariable Long id) {
        accessService.deleteAccess(id);
        return ResponseEntity.noContent().build();
    }


}
