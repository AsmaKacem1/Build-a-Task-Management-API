package com.asmak.controller;

import com.asmak.model.TaskModel;
import com.asmak.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
        return findPaginated(1, "dueDate", "asc", model);
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value = "pageNo") int pageNo, @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<TaskModel> page = taskService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<TaskModel> listTasks = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("tasks", listTasks);
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

    @GetMapping("/tasks/{id}")
    public String deleteTask( @PathVariable Long id){
        taskService.deleteTaskById(id);
        return "redirect:/tasks";
    }


    @GetMapping("/tasks/update/{id}")
    public String editTask( @PathVariable Long id,Model model){
        model.addAttribute("tasks",taskService.getTaskById(id));
        return "task_update";
    }

    @PostMapping("/tasks/{id}")
    public String updateTask( @PathVariable Long id,Model model,@ModelAttribute("taskModel") TaskModel taskModel){
        TaskModel currentTask=taskService.getTaskById(id);
        currentTask.setId(id);
        currentTask.setTitle(taskModel.getTitle());
        currentTask.setDescription(taskModel.getDescription());
        currentTask.setStatus(taskModel.getStatus());
        currentTask.setDueDate(taskModel.getDueDate());
        taskService.updateTask(currentTask);
        return "redirect:/tasks";
    }





}
