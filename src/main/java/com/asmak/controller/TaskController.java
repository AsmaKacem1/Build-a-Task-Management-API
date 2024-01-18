package com.asmak.controller;

import com.asmak.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        System.out.println(model);
        System.out.println("tasksssssssssssssssssssss");
        return "tasks";
    }

}
