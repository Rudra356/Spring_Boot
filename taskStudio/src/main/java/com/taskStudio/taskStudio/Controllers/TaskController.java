package com.taskStudio.taskStudio.Controllers;

import com.taskStudio.taskStudio.TaskDTO.TaskDTO;
import com.taskStudio.taskStudio.TaskServices.TaskServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TaskController {
    @Autowired
    final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }
    //Method for creating a new Task
    @PostMapping(path = "Tasks")
    public TaskDTO createTask(@RequestBody TaskDTO taskDTO){
        return taskServices.createTask(taskDTO);
    }

    //Method for Getting list of Listed Tasks
    @GetMapping(path = "Tasks")
    public List<TaskDTO> getTasks(){
        return taskServices.getTasks();
    }
}
