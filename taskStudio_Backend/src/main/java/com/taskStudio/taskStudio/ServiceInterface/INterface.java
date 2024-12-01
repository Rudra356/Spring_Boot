package com.taskStudio.taskStudio.ServiceInterface;

import com.taskStudio.taskStudio.MaintenanceDTO.MaintenanceDTO;
import com.taskStudio.taskStudio.MaintenanceRepository.MaintenanceRepo;
import org.modelmapper.ModelMapper;

import java.util.List;

public interface INterface {

    public MaintenanceDTO createTask(MaintenanceDTO maintenanceDTO);

    public List<MaintenanceDTO> getTasks();

    MaintenanceDTO GetTaskById(Long MId);

    public boolean deleteTaskById(Long MId) throws InterruptedException;

    public String updateTask(Long MId, @org.jetbrains.annotations.NotNull MaintenanceDTO maintenanceDTO);
}
