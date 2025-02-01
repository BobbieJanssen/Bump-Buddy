package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Checklist;
import com.bodil.Bump.Buddy.repository.interfaces.ChecklistRepository;
import com.bodil.Bump.Buddy.service.interfaces.ChecklistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChecklistServiceImp implements ChecklistService {
    private final ChecklistRepository checklistRepository;

    public ChecklistServiceImp(ChecklistRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    @Override
    public List<Checklist> getAllChecklists() {
        return checklistRepository.findAll();
    }

    @Override
    public Optional<Checklist> getChecklistById(long id) {
        return checklistRepository.findById(id);
    }

    @Override
    public List<Checklist> findAllByUserId(long userId) {
        return checklistRepository.findAllByUserId(userId);
    }

    @Override
    public Checklist createChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    @Override
    public Checklist updateChecklist(long id, Checklist checklist) {
        if (checklistRepository.existsById(id)) {
            return checklistRepository.save(checklist);
        } else {
            throw new RuntimeException("Checklist not found");
        }
    }

    @Override
    public void deleteChecklist(long id) {
        checklistRepository.deleteById(id);
    }
}
