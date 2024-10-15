package com.codingshuttle.anujTutorial.tutorial.EmployeeController;

import com.codingshuttle.anujTutorial.tutorial.EmployeeDTO.EmployeeDTO;
import com.codingshuttle.anujTutorial.tutorial.EmployeeService.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Controller Class
@RestController
public class EmployeeController {

    //This controller only calls services from the EmployeeService class
    final EmployeeService employeeService;

    //Constructor Injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    //For creating new employee
    @PostMapping(path = "createEmployee")
    public EmployeeDTO createEmployee( @RequestBody EmployeeDTO employeeDTO){
        return employeeService.createNewEmployee(employeeDTO);
    }

    //For getting an employee by using their id
    @GetMapping(path = "getEmployee/{id}")
    public EmployeeDTO getEmployee(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }
    //For getting all the listed employees
    @GetMapping(path = "getallemployee")
    public List<EmployeeDTO> getAllEmployee(){
        return employeeService.getAllEmp();
    }
    //For deleting any employee from the database using their id
    @DeleteMapping(path = "EMPDEL/{id}")
    public Boolean deleteEmployee(@PathVariable  Long id){
        return employeeService.DltEmpByID(id);
    }

}
