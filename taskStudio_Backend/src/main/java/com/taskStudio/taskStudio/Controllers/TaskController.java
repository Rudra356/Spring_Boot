package com.taskStudio.taskStudio.Controllers;

import com.taskStudio.taskStudio.TaskDTO.TaskDTO;
import com.taskStudio.taskStudio.TaskServices.TaskServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class TaskController {
    @Autowired
    final TaskServices taskServices;

    public TaskController(TaskServices taskServices) {
        this.taskServices = taskServices;
    }
    //Method for creating a new Task
    @PostMapping(path = "Tasks")
    public TaskDTO createTask(@Valid @RequestBody TaskDTO taskDTO){
        return taskServices.createTask(taskDTO);
    }

    //Method for Getting list of Listed Tasks
    @GetMapping(path = "Tasks")
    public List<TaskDTO> getTasks(){
        return taskServices.getTasks();
    }

    //Method for updating  Listed Tasks
    @PutMapping(path = "Tasks/{taskId}")
    public String updateTask(@PathVariable Long taskId,@RequestBody TaskDTO taskDTO){
        return taskServices.updateTask(taskId,taskDTO);
    }

    //Method for deleting  Listed Tasks
    @DeleteMapping(path = "Tasks/{taskId}")
    public boolean deleteTaskById(@PathVariable Long taskId){
        return taskServices.deleteTaskById(taskId);
    }

    //Method for getting individual Listed Tasks by their ID
    @GetMapping(path = "Tasks/{taskId}")
    public TaskDTO GetTaskById(@PathVariable ("taskId") Long taskId){
        return   taskServices.GetTaskById(taskId);
    }

}
