package com.asmak.controller;

import com.asmak.model.TaskModel;
import com.asmak.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    public TaskController(TaskService taskService) {
        super();
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String listTasks(Model model){
        model.addAttribute("tasks",taskService.getALLTasks());
        return "tasks";
    }

    @GetMapping("/tasks/form")
    public String formTask(Model model){
        TaskModel taskModel=new TaskModel();
        model.addAttribute("tasks",taskModel);
        return "task_form";
    }

    @PostMapping("/tasks")
    public String addedTask(@ModelAttribute("taskModel") TaskModel taskModel){

        taskService.saveTask(taskModel);
        return "redirect:/tasks";
    }





}
