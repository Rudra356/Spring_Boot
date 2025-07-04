package com.taskStudio.taskStudio.DTOs;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {

    private String id; // Optional: Include only if needed

    private String spareName;
    private String RC;
    private String issue;
    private String brandModel;
    private int price;
    private Long currentKM;
    private LocalDate replacingDate;
    private Long upcomingCheckUpKM;
    private String extraNotes;
}
