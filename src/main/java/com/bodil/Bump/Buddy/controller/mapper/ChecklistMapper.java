package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.ChecklistDTO;
import com.bodil.Bump.Buddy.model.Checklist;
import com.bodil.Bump.Buddy.model.Task;
import com.bodil.Bump.Buddy.model.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ChecklistMapper {

    public ChecklistDTO toDTO(Checklist checklist) {
        ChecklistDTO checklistDTO = new ChecklistDTO();
        checklistDTO.setId(checklist.getId());
        checklistDTO.setTitle(checklist.getTitle());
        checklistDTO.setTemplate(checklist.isTemplate());
        checklistDTO.setCreatedAt(checklist.getCreatedAt());
        checklistDTO.setUserId(checklist.getUser().getId());

        // Only add task IDs to the DTO
        checklistDTO.setTaskIds(checklist.getTasks().stream()
                .map(Task::getId)
                .collect(Collectors.toList()));

        return checklistDTO;
    }

    public Checklist toEntity(ChecklistDTO checklistDTO, User user) {
        Checklist checklist = new Checklist();
        checklist.setTitle(checklistDTO.getTitle());
        checklist.setTemplate(checklistDTO.isTemplate());
        checklist.setCreatedAt(checklistDTO.getCreatedAt());
        checklist.setUser(user);
        return checklist;
    }
}

