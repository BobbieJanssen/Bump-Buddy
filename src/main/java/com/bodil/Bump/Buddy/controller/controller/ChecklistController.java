package com.bodil.Bump.Buddy.controller.controller;

import com.bodil.Bump.Buddy.controller.DTO.ChecklistDTO;
import com.bodil.Bump.Buddy.controller.mapper.ChecklistMapper;
import com.bodil.Bump.Buddy.model.Checklist;
import com.bodil.Bump.Buddy.model.User;
import com.bodil.Bump.Buddy.service.interfaces.ChecklistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/checklists")
public class ChecklistController {
    private final ChecklistService checklistService;
    private final ChecklistMapper checklistMapper;

    public ChecklistController(ChecklistService checklistService, ChecklistMapper checklistMapper) {
        this.checklistService = checklistService;
        this.checklistMapper = checklistMapper;
    }

    @GetMapping
    public List<ChecklistDTO> getAllChecklists() {
        return checklistService.getAllChecklists();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistDTO> getChecklistById(@PathVariable Long id) {
        return checklistService.getChecklistById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ChecklistDTO>> getChecklistByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(checklistService.getChecklistByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<ChecklistDTO> createChecklist(@RequestBody ChecklistDTO checklistDTO) {
        ChecklistDTO createdChecklist = checklistService.createChecklist(checklistDTO);
        return ResponseEntity.ok(createdChecklist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChecklistDTO> updateChecklist(@PathVariable Long id, @RequestBody ChecklistDTO checklistDTO) {
        ChecklistDTO updatedChecklist = checklistService.updateChecklist(id, checklistDTO);
        return ResponseEntity.ok(updatedChecklist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChecklist(@PathVariable Long id) {
        checklistService.deleteChecklist(id);
        return ResponseEntity.noContent().build();
    }
}
