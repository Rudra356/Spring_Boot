package com.taskStudio.taskStudio.Controllers;

import com.taskStudio.taskStudio.DTOs.MaintenanceDTO;
import com.taskStudio.taskStudio.ServiceInterface.MaintenanceServicesInterface;
import com.taskStudio.taskStudio.Services.EmailService;
import com.taskStudio.taskStudio.Services.MaintenanceServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Slf4j
@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class MaintenanceController implements MaintenanceServicesInterface {

    private static final Logger logger = Logger.getLogger(MaintenanceController.class.getName());


    @Autowired
    final MaintenanceServices maintenanceServices;

    @Autowired
    private EmailService emailService;


    public MaintenanceController(MaintenanceServices maintenanceServices) {
        this.maintenanceServices = maintenanceServices;
    }
    //For creating a new Records
    @Override
    @PostMapping(path = "Tasks")
    public MaintenanceDTO createTask(@RequestBody MaintenanceDTO maintenanceDTO){
        logger.info("Inside createTask [Controller]...");
        return maintenanceServices.createTask(maintenanceDTO);
    }

    //For Getting list of Listed Records
    @Override
    @GetMapping(path = "Tasks")
    public List<MaintenanceDTO> getTasks(){
        logger.info("Inside getTasks    [Controller]...");
        return maintenanceServices.getTasks();
    }
    @Override
    //For updating  Listed Records
        @PutMapping(path = "Tasks/{MId}")
        public String updateTask(@PathVariable Long MId,@RequestBody MaintenanceDTO maintenanceDTO){
        logger.info("Inside updateTask  [Controller]...");
        return maintenanceServices.updateTask(MId, maintenanceDTO);
        }

    //For deleting  Listed Records
    @Override
    @DeleteMapping(path = "Tasks/{MId}")
    public boolean deleteTaskById(@PathVariable("MId") Long MId) throws InterruptedException {
        logger.info("Inside deleteTaskById  [Controller]...");
        return maintenanceServices.deleteTaskById(MId);
    }


    //For getting individual Listed Records by their MID
    @Override
    @GetMapping(path = "Tasks/{MId}")
    public MaintenanceDTO GetTaskById(@PathVariable("MId") Long MId){

        logger.info("Inside GetTaskById  [Controller]...");
        return   maintenanceServices.GetTaskById(MId);
    }
    //Experimental methods
    //Mail--sender
    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String message) {
        try {
            emailService.sendEmail(to, subject, message);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Failed to send email: " + e.getMessage();
        }
    }
}
