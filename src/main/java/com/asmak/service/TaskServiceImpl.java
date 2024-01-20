package com.asmak.service;

import com.asmak.model.TaskModel;
import com.asmak.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public TaskModel saveTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }

    @Override
    public void deleteTaskById(Long id){
         taskRepository.deleteById(id);
    }

    @Override
    public Page<TaskModel> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return taskRepository.findAll(pageable);
    }

    @Override
    public TaskModel getTaskById(Long id){
        return taskRepository.findById(id).get();
    }
    @Override
    public TaskModel updateTask(TaskModel taskModel){
        return taskRepository.save(taskModel);
    }
}
