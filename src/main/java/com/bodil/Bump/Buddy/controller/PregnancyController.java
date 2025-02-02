package com.bodil.Bump.Buddy.controller;

import com.bodil.Bump.Buddy.model.Pregnancy;
import com.bodil.Bump.Buddy.service.interfaces.PregnancyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pregnancies")
public class PregnancyController {
    private final PregnancyService pregnancyService;

    public PregnancyController(PregnancyService pregnancyService) {
        this.pregnancyService = pregnancyService;
    }

    @GetMapping
    public List<Pregnancy> getAllPregnancies() {
        return pregnancyService.getAllPregnancies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pregnancy> getPregnancyById(@PathVariable Long id) {
        return ResponseEntity.ok(pregnancyService.getPregnancyById(id).orElse(null));
    }

    @PostMapping
    public ResponseEntity<Pregnancy> createPregnancy(@RequestBody Pregnancy pregnancy) {
        return ResponseEntity.ok(pregnancyService.createPregnancy(pregnancy));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pregnancy> updatePregnancy(@PathVariable Long id, @RequestBody Pregnancy pregnancy) {
        return ResponseEntity.ok(pregnancyService.updatePregnancy(id, pregnancy));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregnancy(@PathVariable Long id) {
        pregnancyService.deletePregnancy(id);
        return ResponseEntity.noContent().build();
    }
}
