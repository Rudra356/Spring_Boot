package com.taskStudio.taskStudio.ServiceInterface;

import com.taskStudio.taskStudio.DTOs.MaintenanceDTO;

import java.util.List;

public interface MaintenanceServicesInterface {

    public MaintenanceDTO createTask(MaintenanceDTO maintenanceDTO);

    public List<MaintenanceDTO> getTasks();

    MaintenanceDTO GetTaskById(String MId);

    public boolean deleteTaskById(String MId) throws InterruptedException;

    public String updateTask(Long MId, @org.jetbrains.annotations.NotNull MaintenanceDTO maintenanceDTO);
}
