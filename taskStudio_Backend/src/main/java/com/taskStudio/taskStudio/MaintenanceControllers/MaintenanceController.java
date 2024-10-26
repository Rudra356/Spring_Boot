package com.taskStudio.taskStudio.MaintenanceControllers;

import com.taskStudio.taskStudio.MaintenanceDTO.MaintenanceDTO;
import com.taskStudio.taskStudio.MaintenanceServices.MaintenanceServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class MaintenanceController {
    @Autowired
    final MaintenanceServices maintenanceServices;

    public MaintenanceController(MaintenanceServices maintenanceServices) {
        this.maintenanceServices = maintenanceServices;
    }
    //Method for creating a new Task
    @PostMapping(path = "Tasks")
    public MaintenanceDTO createTask(@Valid @RequestBody MaintenanceDTO maintenanceDTO){
        return maintenanceServices.createTask(maintenanceDTO);
    }

    //Method for Getting list of Listed Tasks
    @GetMapping(path = "Tasks")
    public List<MaintenanceDTO> getTasks(){
        return maintenanceServices.getTasks();
    }

    //Method for updating  Listed Tasks
    @PutMapping(path = "Tasks/{taskId}")
    public String updateTask(@PathVariable Long taskId,@RequestBody MaintenanceDTO maintenanceDTO){
        return maintenanceServices.updateTask(taskId, maintenanceDTO);
    }

    //Method for deleting  Listed Tasks
    @DeleteMapping(path = "Tasks/{taskId}")
    public boolean deleteTaskById(@PathVariable Long taskId){
        return maintenanceServices.deleteTaskById(taskId);
    }

    //Method for getting individual Listed Tasks by their ID
    @GetMapping(path = "Tasks/{taskId}")
    public MaintenanceDTO GetTaskById(@PathVariable ("taskId") Long taskId){
        return   maintenanceServices.GetTaskById(taskId);
    }

}
