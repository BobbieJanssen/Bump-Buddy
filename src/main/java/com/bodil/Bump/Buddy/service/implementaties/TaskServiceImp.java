package com.bodil.Bump.Buddy.service.implementaties;

import com.bodil.Bump.Buddy.controller.DTO.TaskDTO;
import com.bodil.Bump.Buddy.controller.mapper.TaskMapper;
import com.bodil.Bump.Buddy.model.Checklist;
import com.bodil.Bump.Buddy.model.Task;
import com.bodil.Bump.Buddy.repository.interfaces.ChecklistRepository;
import com.bodil.Bump.Buddy.repository.interfaces.TaskRepository;
import com.bodil.Bump.Buddy.service.interfaces.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository taskRepository;
    private final ChecklistRepository checklistRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImp(TaskRepository taskRepository,
                          ChecklistRepository checklistRepository,
                          TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.checklistRepository = checklistRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<TaskDTO> getTaskById(Long id) {
        return taskRepository.findById(id)
                .map(taskMapper::toDTO);
    }

    @Override
    public List<TaskDTO> findAllByChecklistId(Long checklistId) {
        return taskRepository.findAllByChecklistId(checklistId).stream()
                .map(taskMapper::toDTO)
                .toList();
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        Checklist checklist = checklistRepository.findById(taskDTO.getChecklistId())
                .orElseThrow(() -> new RuntimeException("Checklist not found"));
        Task task = taskMapper.toEntity(taskDTO, checklist);
        Task savedTask = taskRepository.save(task);
        return taskMapper.toDTO(savedTask);
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
       Task task = taskRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Task not found"));

       task.setDescription(taskDTO.getDescription());
       task.setCompleted(taskDTO.isCompleted());

       Task updatedTask = taskRepository.save(task);
       return taskMapper.toDTO(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void markTaskAsCompleted(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setIsCompleted(true);
        taskRepository.save(task);
    }
}
