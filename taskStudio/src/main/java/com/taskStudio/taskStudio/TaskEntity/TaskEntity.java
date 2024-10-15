package com.taskStudio.taskStudio.TaskEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "Task_Entry")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    private String taskName;
    private LocalDateTime taskTime;
    @JsonProperty("isCompleted")
    private Boolean isCompleted;
}
