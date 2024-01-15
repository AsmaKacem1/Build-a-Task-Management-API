package com.asmak.controller;

import com.asmak.model.Task;
import com.asmak.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }

    @GetMapping("/date/{date}")
    public List<Task> getTasksByDate(@PathVariable Date date) {
        return taskService.getTasksDate(date);
    }

    @GetMapping("/title/{title}")
    public List<Task> getTasksByTitle(@PathVariable String title) {
        return taskService.getTasksByTitle(title);
    }

    @GetMapping("/description/{description}")
    public List<Task> getTasksByDescription(@PathVariable String description) {
        return taskService.getTasksByDescription(description);
    }

    @DeleteMapping("/status/{status}")
    public void deleteTasksByStatus(@PathVariable String status) {
        taskService.deleteTasksByStatus(status);
    }
}
