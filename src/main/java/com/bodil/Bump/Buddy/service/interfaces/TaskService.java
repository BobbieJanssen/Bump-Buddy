package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.controller.DTO.TaskDTO;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<TaskDTO> getAllTasks();
    Optional<TaskDTO> getTaskById(Long id);
    List<TaskDTO> findAllByChecklistId(Long checklistId);
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id);
    void markTaskAsCompleted(Long id);
}
