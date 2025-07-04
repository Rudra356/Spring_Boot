package com.taskStudio.taskStudio.ControllerInterface;

import com.taskStudio.taskStudio.DTOs.MaintenanceDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MaintenanceControllerInterface {
    //For creating new maintenance records
    public MaintenanceDTO createTask(@Valid @RequestBody MaintenanceDTO maintenanceDTO);
    //For getting list of maintenance records
    public List<MaintenanceDTO> getTasks();
    //For deleting maintenance records
    public boolean deleteTaskById(@PathVariable String MId) throws InterruptedException;
    //For getting maintenance records by their MID's'
    public MaintenanceDTO GetTaskById(@PathVariable("MId") String MId);


}
