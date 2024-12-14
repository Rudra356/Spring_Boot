package com.taskStudio.taskStudio.Controllers;

import com.taskStudio.taskStudio.DTOs.MaintenanceDTO;
import com.taskStudio.taskStudio.ServiceInterface.MaintenanceServicesInterface;
import com.taskStudio.taskStudio.Services.EmailService;
import com.taskStudio.taskStudio.Services.MaintenanceServices;
import jakarta.validation.Valid;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class MaintenanceController implements MaintenanceServicesInterface {
    @Autowired
    final MaintenanceServices maintenanceServices;

    @Autowired
    private EmailService emailService;

    public JavaMailSender javaMailSender;

    public MaintenanceController(MaintenanceServices maintenanceServices) {
        this.maintenanceServices = maintenanceServices;
    }
    //Method for creating a new Records
    @Override
    @PostMapping(path = "Tasks")
    public MaintenanceDTO createTask(@RequestBody MaintenanceDTO maintenanceDTO){
        return maintenanceServices.createTask(maintenanceDTO);
    }

    //Method for Getting list of Listed Records
    @Override
    @GetMapping(path = "Tasks")
    public List<MaintenanceDTO> getTasks(){
        return maintenanceServices.getTasks();
    }
    @Override
    //Method for updating  Listed Records
        @PutMapping(path = "Tasks/{MId}")
        public String updateTask(@PathVariable Long MId,@RequestBody MaintenanceDTO maintenanceDTO){
            return maintenanceServices.updateTask(MId, maintenanceDTO);
        }

    //Method for deleting  Listed Records
    @Override
    @DeleteMapping(path = "Tasks/{MId}")
    public boolean deleteTaskById(@PathVariable Long MId) throws InterruptedException {

        return maintenanceServices.deleteTaskById(MId);
    }


    //Method for getting individual Listed Records by their MID
    @Override
    @GetMapping(path = "Tasks/{MId}")
    public MaintenanceDTO GetTaskById(@PathVariable("MId") Long MId){
        return   maintenanceServices.GetTaskById(MId);
    }

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
