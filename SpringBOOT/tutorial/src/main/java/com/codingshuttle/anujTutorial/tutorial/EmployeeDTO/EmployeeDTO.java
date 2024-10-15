package com.codingshuttle.anujTutorial.tutorial.EmployeeDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

//EmployeeDTO can send and receive data between the CONTROLLER and SERVICE layer
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate joinDate;
    @JsonProperty("isActive")
    private boolean isActive;
}
