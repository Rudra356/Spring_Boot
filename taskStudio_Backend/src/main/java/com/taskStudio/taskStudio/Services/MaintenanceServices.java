package com.taskStudio.taskStudio.Services;

import com.taskStudio.taskStudio.MaintenanceDTO.MaintenanceDTO;
import com.taskStudio.taskStudio.MaintenanceEntity.MaintenanceEntity;
import com.taskStudio.taskStudio.MaintenanceRepository.MaintenanceRepo;
import com.taskStudio.taskStudio.ServiceInterface.INterface;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServices implements INterface {
    final MaintenanceRepo maintenanceRepo;
    final ModelMapper modelMapper;
    public MaintenanceServices(MaintenanceRepo maintenanceRepo, ModelMapper modelMapper) {
        this.maintenanceRepo = maintenanceRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    //POST Method
    //For creating a new Records
    public MaintenanceDTO createTask(MaintenanceDTO maintenanceDTO) {
        try {
            MaintenanceEntity maintenanceEntity = modelMapper.map(maintenanceDTO, MaintenanceEntity.class);
            return modelMapper.map(maintenanceRepo.save(maintenanceEntity), MaintenanceDTO.class);
        } catch (Exception e) {
            return null;
        }
    }

    //GET Method
    //For getting all the listed Records
    @Override
    public List<MaintenanceDTO> getTasks() {
        try{
            List<MaintenanceDTO> list = new ArrayList<>();
            Thread.sleep(700);
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
    //For getting the listed Records by their MID
    @Override
    public MaintenanceDTO GetTaskById(Long MId) {
        MaintenanceEntity maintenanceEntity = maintenanceRepo.findById(MId).get();
        return  modelMapper.map(maintenanceEntity, MaintenanceDTO.class);
    }

    //DELETE Method
    //For deleting the listed Records by their MID's
    @Override
    public boolean deleteTaskById(Long MId) throws InterruptedException {
        Thread.yield();
        Thread.sleep(1000);
        MaintenanceEntity task = maintenanceRepo.findById(MId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + MId));

        maintenanceRepo.delete(task);
        return true;
    }

    //PUT Method
    //For updating all the listed Records by their ID's
    @Override
    public String updateTask(Long MId, @org.jetbrains.annotations.NotNull MaintenanceDTO maintenanceDTO) {
        MaintenanceEntity existTask = maintenanceRepo.findById(MId).get();
        existTask.setSpareName(maintenanceDTO.getSpareName());
        existTask.setRC(maintenanceDTO.getRC());
        existTask.setIssue(maintenanceDTO.getIssue());
        existTask.setBrandModel(maintenanceDTO.getBrandModel());
        existTask.setPrice(maintenanceDTO.getPrice());
        existTask.setCurrentKM(maintenanceDTO.getCurrentKM());
        existTask.setReplacingDate(maintenanceDTO.getReplacingDate());
        existTask.setUpcomingCheckUpKM(maintenanceDTO.getUpcomingCheckUpKM());
        // existTask.setUpcomingCheckUpDATE(maintenanceDTO.getReplacingDate());
        existTask.setExtraNotes(maintenanceDTO.getExtraNotes());
        maintenanceRepo.save(existTask);
        return "Updated sucessfully...";
    }

}
