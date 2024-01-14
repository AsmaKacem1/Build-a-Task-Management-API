package com.asmak.service;

import com.asmak.model.Task;

import java.util.Date;
import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task getTaskById(Long id);

    void createTask(Task task);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);

    List<Task> getTasksByStatus(String status);

    List<Task> getTasksDate(Date date);

    List<Task> getTasksByTitle(String title);

    public List<Task> getTasksByDescription(String description);

    void deleteTasksByStatus(String status);


}
