package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.controller.DTO.ChecklistDTO;
import com.bodil.Bump.Buddy.controller.mapper.ChecklistMapper;
import com.bodil.Bump.Buddy.model.Checklist;
import com.bodil.Bump.Buddy.model.User;
import com.bodil.Bump.Buddy.repository.interfaces.ChecklistRepository;
import com.bodil.Bump.Buddy.repository.interfaces.UserRepository;
import com.bodil.Bump.Buddy.service.interfaces.ChecklistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChecklistServiceImp implements ChecklistService {
    private final ChecklistRepository checklistRepository;
    private final ChecklistMapper checklistMapper;
    private final UserRepository userRepository;

    public ChecklistServiceImp(ChecklistRepository checklistRepository,
                               ChecklistMapper checklistMapper,
                               UserRepository userRepository) {
        this.checklistRepository = checklistRepository;
        this.checklistMapper = checklistMapper;
        this.userRepository = userRepository;
    }

    @Override
    public List<ChecklistDTO> getAllChecklists() {
        return checklistRepository.findAll().stream()
                .map(checklistMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ChecklistDTO> getChecklistById(Long id) {
        return checklistRepository.findById(id)
                .map(checklistMapper::toDTO);
    }

    @Override
    public List<ChecklistDTO> getChecklistByUserId(Long userId) {
        return checklistRepository.findAllByUserId(userId).stream()
                .map(checklistMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ChecklistDTO createChecklist(ChecklistDTO checklistDTO) {
        User user = userRepository.findById(checklistDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Checklist checklist = checklistMapper.toEntity(checklistDTO, user);
        Checklist savedChecklist = checklistRepository.save(checklist);

        return checklistMapper.toDTO(savedChecklist);
    }

    @Override
    public ChecklistDTO updateChecklist(Long id, ChecklistDTO checklistDTO) {
        Checklist existingChecklist = checklistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Checklist not found"));

        existingChecklist.setTitle(checklistDTO.getTitle());
        existingChecklist.setTemplate(checklistDTO.isTemplate());

        Checklist updatedChecklist = checklistRepository.save(existingChecklist);

        return checklistMapper.toDTO(updatedChecklist);
    }

    @Override
    public void deleteChecklist(Long id) {
        checklistRepository.deleteById(id);
    }
}
