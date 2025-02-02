package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.model.Task;
import com.bodil.Bump.Buddy.repository.interfaces.TaskRepository;
import com.bodil.Bump.Buddy.service.interfaces.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> findAllByChecklistId(Long checklistId) {
        return taskRepository.findAllByChecklistId(checklistId);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        if (taskRepository.existsById(id)) {
            return taskRepository.save(task);
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void markTaskAsCompleted(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setIsCompleted(true);
        taskRepository.save(task);
    }
}
