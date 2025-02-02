package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Checklist;

import java.util.List;
import java.util.Optional;

public interface ChecklistService {
    List<Checklist> getAllChecklists();
    Optional<Checklist> getChecklistById(Long id);
    List<Checklist> getChecklistByUserId(Long userId);
    Checklist createChecklist(Checklist checklist);
    Checklist updateChecklist(Long id, Checklist checklist);
    void deleteChecklist(Long id);
}
