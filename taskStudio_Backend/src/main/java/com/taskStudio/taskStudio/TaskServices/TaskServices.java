package com.taskStudio.taskStudio.TaskServices;

import com.taskStudio.taskStudio.TaskDTO.TaskDTO;
import com.taskStudio.taskStudio.TaskEntity.TaskEntity;
import com.taskStudio.taskStudio.TaskRepository.TaskRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
    final TaskRepo taskRepo;
    final ModelMapper modelMapper;
    public TaskServices(TaskRepo taskRepo, ModelMapper modelMapper) {
        this.taskRepo = taskRepo;
        this.modelMapper = modelMapper;
    }
    //POST Method
    //For creating a new Task
    public TaskDTO createTask(TaskDTO taskDTO) {
        try {
            TaskEntity taskEntity = modelMapper.map(taskDTO,TaskEntity.class);
            return modelMapper.map(taskRepo.save(taskEntity),TaskDTO.class);
        } catch (Exception e) {
            return null;
        }
    }
    //GET Method
    //For getting all the listed tasks
    public List<TaskDTO> getTasks() {
        try{
            List<TaskDTO> list = new ArrayList<>();
            for ( TaskEntity taskEntity: taskRepo.findAll()){
                TaskDTO newl = modelMapper.map(taskEntity,TaskDTO.class);
                list.add(newl);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    //GET Method
    //For getting the listed tasks by their ID
    public TaskDTO GetTaskById(Long taskId) {
        TaskEntity taskEntity =taskRepo.findById(taskId).get();
        return  modelMapper.map(taskEntity,TaskDTO.class);
    }
    //DELETE Method
    //For deleting the listed tasks by their ID's
    public boolean deleteTaskById(Long taskId) {
        // Check if the task exists in the database
        Optional<TaskEntity> taskOptional = taskRepo.findById(taskId);

        if (taskOptional.isPresent()) {
            // Task exists, so delete it
            taskRepo.delete(taskOptional.get());
            return true;  // Return true for successful deletion
        } else {
            // Task doesn't exist, throw an exception or handle it accordingly
            try {
                throw new Exception("Task not found with id: " + taskId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    //PUT Method
    //For updating all the listed tasks by their ID's
    public String updateTask(Long taskId, TaskDTO taskDTO) {
        TaskEntity existTask = taskRepo.findById(taskId).get();
        existTask.setTaskName(taskDTO.getTaskName());
        existTask.setTaskTime(taskDTO.getTaskTime());
        existTask.setTaskDate(taskDTO.getTaskDate());
        taskRepo.save(existTask);
        return "Update sucessfully...";
    }

}
