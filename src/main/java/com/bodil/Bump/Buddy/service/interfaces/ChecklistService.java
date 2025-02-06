package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.ChecklistDTO;

import java.util.List;
import java.util.Optional;

public interface ChecklistService {
    List<ChecklistDTO> getAllChecklists();
    Optional<ChecklistDTO> getChecklistById(Long id);
    List<ChecklistDTO> getChecklistByUserId(Long userId);
    ChecklistDTO createChecklist(ChecklistDTO checklistDTO);
    ChecklistDTO updateChecklist(Long id, ChecklistDTO checklistDTO);
    void deleteChecklist(Long id);
}
