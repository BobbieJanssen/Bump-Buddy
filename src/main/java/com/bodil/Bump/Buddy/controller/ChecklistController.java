package com.bodil.Bump.Buddy.controller;

import com.bodil.Bump.Buddy.model.Checklist;
import com.bodil.Bump.Buddy.service.interfaces.ChecklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checklists")
public class ChecklistController {
    private final ChecklistService checklistService;

    public ChecklistController(ChecklistService checklistService) {
        this.checklistService = checklistService;
    }

    @GetMapping
    public List<Checklist> getAllChecklists() {
        return checklistService.getAllChecklists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checklist> getChecklistById(@PathVariable Long id) {
        return ResponseEntity.ok(checklistService.getChecklistById(id).orElse(null));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Checklist>> getChecklistByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(checklistService.getChecklistByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Checklist> createChecklist(@RequestBody Checklist checklist) {
        return ResponseEntity.ok(checklistService.createChecklist(checklist));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checklist> updateChecklist(@PathVariable Long id, @RequestBody Checklist checklist) {
        return ResponseEntity.ok(checklistService.updateChecklist(id, checklist));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChecklist(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
        return ResponseEntity.noContent().build();
    }
}
