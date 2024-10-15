package com.taskStudio.taskStudio.TaskServices;

import com.taskStudio.taskStudio.TaskDTO.TaskDTO;
import com.taskStudio.taskStudio.TaskEntity.TaskEntity;
import com.taskStudio.taskStudio.TaskRepository.TaskRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    //
}
