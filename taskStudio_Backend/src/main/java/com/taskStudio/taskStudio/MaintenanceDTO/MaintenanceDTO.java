package com.taskStudio.taskStudio.MaintenanceDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MaintenanceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    @NotBlank(message = "Task name cannot be blank")
    @Size(min = 3, max = 10, message = "Task name must be between 3 and 10 characters")
    private String taskName;

    private LocalTime taskTime;

    @NotNull
    @FutureOrPresent(message = "Task date must be today or in the future")
    private LocalDate taskDate;

//    @JsonProperty("isCompleted")
//    private Boolean isCompleted;

}
