package com.taskStudio.taskStudio.TaskRepository;


import com.taskStudio.taskStudio.TaskEntity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity, Long > {
}
