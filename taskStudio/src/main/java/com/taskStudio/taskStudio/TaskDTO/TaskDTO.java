package com.taskStudio.taskStudio.TaskDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document
public class TaskDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String taskName;
    private LocalDateTime taskTime;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;

}
