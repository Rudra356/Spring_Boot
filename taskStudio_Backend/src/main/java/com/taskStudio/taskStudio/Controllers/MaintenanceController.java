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

@RestController
//@CrossOrigin(origins = "http://localhost:3000/")
public class MaintenanceController {

    private static final Logger logger = Logger.getLogger(MaintenanceController.class.getName());


    @Autowired
    final MaintenanceServices maintenanceServices;

    @Autowired
    private EmailService emailService;


    public MaintenanceController(MaintenanceServices maintenanceServices) {
        this.maintenanceServices = maintenanceServices;
    }
    //For creating a new Records

    @PostMapping(path = "Tasks")
    public MaintenanceDTO createTask(@RequestBody MaintenanceDTO maintenanceDTO){
        logger.info("Inside createTask [Controller]...");
        System.out.println(maintenanceDTO);
        return maintenanceServices.createTask(maintenanceDTO);
    }

    //For Getting list of Listed Records

    @GetMapping("Tasks")
    public List<MaintenanceDTO> getTasks(){
        logger.info("Inside getTasks    [Controller]...");
        return maintenanceServices.getTasks();
    }

    //For updating  Listed Records
        @PutMapping("Tasks/{MId}")
        public String updateTask(@PathVariable String MId,@RequestBody MaintenanceDTO maintenanceDTO){
        logger.info("Inside updateTask  [Controller]...");
        return maintenanceServices.updateTask(MId, maintenanceDTO);
        }

    //For deleting  Listed Records

    @DeleteMapping("Tasks/{MId}")
    public boolean deleteTaskById(@PathVariable("MId") String MId) throws InterruptedException {
        logger.info("Inside deleteTaskById  [Controller]...");
        return maintenanceServices.deleteTaskById(MId);
    }


    //For getting individual Listed Records by their MID

    @GetMapping("Tasks/{MId}")
    public MaintenanceDTO GetTaskById(@PathVariable("MId") String MId){

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
