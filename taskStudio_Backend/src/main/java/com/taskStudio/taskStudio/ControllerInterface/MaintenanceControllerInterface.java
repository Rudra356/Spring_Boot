package com.taskStudio.taskStudio.ControllerInterface;

import com.taskStudio.taskStudio.DTOs.MaintenanceDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MaintenanceControllerInterface {

    public MaintenanceDTO createTask(@Valid @RequestBody MaintenanceDTO maintenanceDTO);

    public List<MaintenanceDTO> getTasks();

    public boolean deleteTaskById(@PathVariable Long MId) throws InterruptedException;

    public MaintenanceDTO GetTaskById(@PathVariable("MId") Long MId);


}
