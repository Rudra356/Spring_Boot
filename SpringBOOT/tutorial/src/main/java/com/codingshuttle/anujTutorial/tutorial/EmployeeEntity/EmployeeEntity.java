package com.codingshuttle.anujTutorial.tutorial.EmployeeEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

//Entity Class
//EmployeeEntity can send and receive data between the SERVICE and PERSISTENCE layer
@Entity
@Table(name = "EMPDB")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //Auto-Generated PRIMARY_KEY
    private String name;
    private LocalDate joinDate;
    @JsonProperty("isActive")
    private boolean isActive;
}
