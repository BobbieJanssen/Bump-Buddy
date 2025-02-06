package com.bodil.Bump.Buddy.controller.mapper;

import com.bodil.Bump.Buddy.controller.DTO.TaskDTO;
import com.bodil.Bump.Buddy.model.Checklist;
import com.bodil.Bump.Buddy.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDTO toDTO(Task task) {
        return new TaskDTO(
                task.getId(),
                task.getDescription(),
                task.isCompleted(),
                task.getChecklist() != null ? task.getChecklist().getId() : null
        );
    }

    public Task toEntity(TaskDTO taskDTO, Checklist checklist) {
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setCompleted(taskDTO.isCompleted());
        task.setChecklist(checklist);
        return task;
    }
}

