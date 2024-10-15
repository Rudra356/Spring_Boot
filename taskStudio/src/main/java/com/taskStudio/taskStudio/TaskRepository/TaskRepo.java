package com.taskStudio.taskStudio.TaskRepository;

import com.taskStudio.taskStudio.TaskEntity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends MongoRepository<TaskEntity, Long > {
}
