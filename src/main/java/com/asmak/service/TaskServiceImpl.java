package com.asmak.service;

import com.asmak.model.TaskModel;
import com.asmak.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository) {
        super();
        this.taskRepository = taskRepository;
    }

    @Override
    public List<TaskModel> getALLTasks() {
        return taskRepository.findAll();
    }
}
