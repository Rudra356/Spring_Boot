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
    //Method for creating a new Records
    @PostMapping(path = "Tasks")
    public MaintenanceDTO createTask(@Valid @RequestBody MaintenanceDTO maintenanceDTO){
        return maintenanceServices.createTask(maintenanceDTO);
    }

    //Method for Getting list of Listed Records
    @GetMapping(path = "Tasks")
    public List<MaintenanceDTO> getTasks(){
        return maintenanceServices.getTasks();
    }

    //Method for updating  Listed Records
    //    @PutMapping(path = "Tasks/{MId}")
    //    public String updateTask(@PathVariable Long MId,@RequestBody MaintenanceDTO maintenanceDTO){
    //        return maintenanceServices.updateTask(MId, maintenanceDTO);
    //    }

    //Method for deleting  Listed Records
    @DeleteMapping(path = "Tasks/{MId}")
    public boolean deleteTaskById(@PathVariable Long MId) throws InterruptedException {

        return maintenanceServices.deleteTaskById(MId);
    }

    //Method for getting individual Listed Records by their MID
    @GetMapping(path = "Tasks/{MId}")
    public MaintenanceDTO GetTaskById(@PathVariable("MId") Long MId){
        return   maintenanceServices.GetTaskById(MId);
    }

}
