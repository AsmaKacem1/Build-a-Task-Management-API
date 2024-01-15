package com.asmak.repository;

import com.asmak.model.Task;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(String status);

    List<Task> findByDueDate(Date dueDate);

    List<Task> findByTitleEquals(String title);

    List<Task> findByDescription(String description);

    void deleteByStatus(String status);

}
