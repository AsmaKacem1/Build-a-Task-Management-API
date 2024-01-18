package com.asmak.repository;

import com.asmak.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel,Long> {
}
