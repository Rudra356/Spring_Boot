package com.codingshuttle.anujTutorial.tutorial.EmployeeService;

import com.codingshuttle.anujTutorial.tutorial.EmployeeDTO.EmployeeDTO;
import com.codingshuttle.anujTutorial.tutorial.EmployeeEntity.EmployeeEntity;
import com.codingshuttle.anujTutorial.tutorial.EmployeeRepository.EmployeeRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//Service Class
@Service
public class EmployeeService {

    //Service Class calls EmployeeRepository Class for performing necessary tasks
    final EmployeeRepository employeeRepository;
    final ModelMapper modelmapper;

    //Constructor Injection
    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelmapper) {
        this.employeeRepository = employeeRepository;
        this.modelmapper = modelmapper;
    }
    //This service helps to find an employee using their id
    public EmployeeDTO getEmployeeById(Long id){
        try{
            EmployeeEntity employeeEntity=employeeRepository.getById(id);
        return modelmapper.map(employeeEntity,EmployeeDTO.class);
        }
        catch (Exception e) {
           return null;
        }
        // return new EmployeeDTO(employeeEntity.getId(), employeeEntity.getName(), employeeEntity.getJoinDate(), employeeEntity.isActive());
    }
    //This service creates a new employee
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelmapper.map(employeeDTO,EmployeeEntity.class);
        return modelmapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }
    //This service helps to find all the LIST of employees
    public List<EmployeeDTO> getAllEmp() {
    // employeeRepository.findAll();
       List<EmployeeDTO> list = new ArrayList<>();
       for(EmployeeEntity employeeEntity : employeeRepository.findAll()){
           EmployeeDTO map = modelmapper.map(employeeEntity,EmployeeDTO.class);
           list.add(map);
       }
       return list;
    }
    //This boolean method check if their any existing employee in the DB with a corresponding ID
    //if yes it will delete this record and return true else its will return false
    public Boolean DltEmpByID(Long id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(isPresent){
        employeeRepository.deleteById(id);
        return true;}
        return false;
    }
    //This method is for updating an existing record
    public String upemp(Long id, EmployeeDTO employeeDTO) {
        //   Method 1
        //  EmployeeEntity employeeEntity=modelmapper.map(employeeRepository.findById(id),EmployeeEntity.class);
        //  return modelmapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
        //   Method 2
        //        if(employeeRepository.existsById(id)){
        //        EmployeeEntity employeeEntity = modelmapper.map(employeeDTO,EmployeeEntity.class);
        //        employeeRepository.save(employeeEntity);
        //           return "Updated succesfully...";
        //        }
        //        return "Employee not found";

        //Method 3
        try{
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setJoinDate(employeeDTO.getJoinDate());
        employeeEntity.setActive(employeeDTO.isActive());
        employeeRepository.save(employeeEntity);
        return "Updated succesfully...";
        } catch (Exception e) {
            return "Record not found...";
        }
    }

}


