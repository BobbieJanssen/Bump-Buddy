package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.controller.DTO.AccessDTO;
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
    public ResponseEntity<AccessDTO> getAccessById(@PathVariable Long id) {
        return accessService.getAccessById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<AccessDTO> getAllAccess() {
        return accessService.getAllAccess();
    }

    @PostMapping
    public ResponseEntity<AccessDTO> createAccess(@RequestBody AccessDTO accessDTO) {
        return ResponseEntity.ok(accessService.createAccess(accessDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccessDTO> updateAccess(@PathVariable Long id, @RequestBody AccessDTO accessDTO) {
        return ResponseEntity.ok(accessService.updateAccess(id, accessDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccess(@PathVariable Long id) {
        accessService.deleteAccess(id);
        return ResponseEntity.noContent().build();
    }
}
