package com.bodil.Bump.Buddy.service.interfaces;

import com.bodil.Bump.Buddy.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAllTasks();
    Optional<Task> getTaskById(long id);
    List<Task> findAllByChecklistId(long checklistId);
    Task createTask(Task task);
    Task updateTask(long id, Task task);
    void deleteTask(long id);
    void markTaskAsCompleted(long taskId);
}
