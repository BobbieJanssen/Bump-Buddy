package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    List<Task> findAllByChecklistId(Long checklistId);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    void markTaskAsCompleted(Long id);
}
