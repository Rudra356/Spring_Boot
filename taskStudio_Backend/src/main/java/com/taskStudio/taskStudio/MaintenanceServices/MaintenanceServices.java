package com.taskStudio.taskStudio.MaintenanceServices;

import com.taskStudio.taskStudio.MaintenanceDTO.MaintenanceDTO;
import com.taskStudio.taskStudio.MaintenanceEntity.MaintenanceEntity;
import com.taskStudio.taskStudio.MaintenanceRepository.MaintenanceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceServices {
    final MaintenanceRepo maintenanceRepo;
    final ModelMapper modelMapper;
    public MaintenanceServices(MaintenanceRepo maintenanceRepo, ModelMapper modelMapper) {
        this.maintenanceRepo = maintenanceRepo;
        this.modelMapper = modelMapper;
    }
    //POST Method
    //For creating a new Task
    public MaintenanceDTO createTask(MaintenanceDTO maintenanceDTO) {
        try {
            MaintenanceEntity maintenanceEntity = modelMapper.map(maintenanceDTO, MaintenanceEntity.class);
            return modelMapper.map(maintenanceRepo.save(maintenanceEntity), MaintenanceDTO.class);
        } catch (Exception e) {
            return null;
        }
    }
    //GET Method
    //For getting all the listed tasks
    public List<MaintenanceDTO> getTasks() {
        try{
            List<MaintenanceDTO> list = new ArrayList<>();
            for ( MaintenanceEntity maintenanceEntity : maintenanceRepo.findAll()){
                MaintenanceDTO newl = modelMapper.map(maintenanceEntity, MaintenanceDTO.class);
                list.add(newl);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
    //GET Method
    //For getting the listed tasks by their ID
    public MaintenanceDTO GetTaskById(Long MId) {
        MaintenanceEntity maintenanceEntity = maintenanceRepo.findById(MId).get();
        return  modelMapper.map(maintenanceEntity, MaintenanceDTO.class);
    }
    //DELETE Method
    //For deleting the listed tasks by their ID's
    public boolean deleteTaskById(Long MId) {
        // Check if the task exists in the database
        Optional<MaintenanceEntity> taskOptional = maintenanceRepo.findById(MId);

        if (taskOptional.isPresent()) {
            // Task exists, so delete it
            maintenanceRepo.delete(taskOptional.get());
            return true;  // Return true for successful deletion
        } else {
            // Task doesn't exist, throw an exception or handle it accordingly
            try {
                throw new Exception("Task not found with id: " + MId);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    //PUT Method
    //For updating all the listed tasks by their ID's
    public String updateTask(Long MId, MaintenanceDTO maintenanceDTO) {
        MaintenanceEntity existTask = maintenanceRepo.findById(MId).get();
        existTask.setSpareName(maintenanceDTO.getSpareName());
        existTask.setIssue(maintenanceDTO.getIssue());
        existTask.setBrandModel(maintenanceDTO.getBrandModel());
        existTask.setPrice(maintenanceDTO.getPrice());
        existTask.setReplacingDate(maintenanceDTO.getReplacingDate());
        existTask.setUpcomingCheckUpKM(maintenanceDTO.getUpcomingCheckUpKM());
        existTask.setUpcomingCheckUpDATE(maintenanceDTO.getReplacingDate());
//        existTask.setExtraNotes(maintenanceDTO.setExtraNotes());
        maintenanceRepo.save(existTask);
        return "Updated sucessfully...";
    }

}
