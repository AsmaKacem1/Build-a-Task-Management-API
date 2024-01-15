package com.asmak.service;

import com.asmak.model.Task;
import com.asmak.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void updateTask(Long id, Task task) {
        taskRepository.findById(id).ifPresent(existingTask -> {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            existingTask.setDueDate(task.getDueDate());
            taskRepository.save(existingTask);
        });
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public List<Task> getTasksDate(Date date) {
        return taskRepository.findByDueDate(date);
    }

    @Override
    public List<Task> getTasksByTitle(String title) {
        return taskRepository.findByTitleEquals(title);
    }

    @Override
    public List<Task> getTasksByDescription(String description) {
        return taskRepository.findByDescription(description);
    }

    @Override
    public void deleteTasksByStatus(String status) {
        taskRepository.deleteByStatus(status);
    }


}
