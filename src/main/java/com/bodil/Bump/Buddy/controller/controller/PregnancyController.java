package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.controller.DTO.PregnancyDTO;
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
    public List<PregnancyDTO> getAllPregnancies() {
        return pregnancyService.getAllPregnancies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PregnancyDTO> getPregnancyById(@PathVariable Long id) {
        return pregnancyService.getPregnancyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PregnancyDTO> createPregnancy(@RequestBody PregnancyDTO pregnancyDTO) {
        return ResponseEntity.ok(pregnancyService.createPregnancy(pregnancyDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PregnancyDTO> updatePregnancy(@PathVariable Long id, @RequestBody PregnancyDTO pregnancyDTO) {
        return ResponseEntity.ok(pregnancyService.updatePregnancy(id, pregnancyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregnancy(@PathVariable Long id) {
        pregnancyService.deletePregnancy(id);
        return ResponseEntity.noContent().build();
    }
}
