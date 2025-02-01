package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Checklist;

import java.util.List;
import java.util.Optional;

public interface ChecklistService {
    List<Checklist> getAllChecklists();
    Optional<Checklist> getChecklistById(long id);
    List<Checklist> findAllByUserId(long userId);
    Checklist createChecklist(Checklist checklist);
    Checklist updateChecklist(long id, Checklist checklist);
    void deleteChecklist(long id);
}
