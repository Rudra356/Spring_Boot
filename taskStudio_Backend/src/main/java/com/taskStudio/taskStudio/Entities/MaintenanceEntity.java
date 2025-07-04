package com.taskStudio.taskStudio.Entities;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "maintenance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceEntity {
    @Id
    private String id; // MongoDB's _id

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
