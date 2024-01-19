package com.asmak.service;

import com.asmak.model.TaskModel;

import java.util.List;

public interface TaskService {
    List<TaskModel> getALLTasks();

    TaskModel saveTask(TaskModel taskModel);



    TaskModel getTaskById(Long id);
    TaskModel updateTask(TaskModel taskModel);


    void deleteTaskById(Long id);
}
