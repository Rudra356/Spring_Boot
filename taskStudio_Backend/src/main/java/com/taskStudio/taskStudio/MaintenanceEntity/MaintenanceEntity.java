package com.taskStudio.taskStudio.MaintenanceEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MaintenanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MId; //This variable is auto-generated for storing Maintenance ID ...

    @Size(min = 3, max = 10, message = "Spare name must be between 3 and 40 characters")
    private String spareName; //This variable is for storing Spare Name...

    private String issue; //This variable is for storing related or possible issues causing the Spare change ...

    private String brandModel; //This variable is for storing Spare Brand & Model...

    @PositiveOrZero(message = "The number must be zero or positive")
    private int price; //This variable is for storing Spare Price ...


    private LocalDate replacingDate; //This variable is for storing Spare replacing Date...

    @NotNull(message = "Upcoming check-up KM cannot be null")
    @Min(value = 0, message = "Upcoming check-up KM must be non-negative")
    private long upcomingCheckUpKM; //This variable is for storing Upcoming Spare Checkup in KMs...

    @FutureOrPresent(message = "CheckUp date must be today or in the future")
    private LocalDate upcomingCheckUpDATE; //This variable is for storing Upcoming Spare Checkup in Time...

    // private String extraNotes;   // This variable is for storing extra notes if needed ...

    //    @Id
    //    @GeneratedValue(strategy = GenerationType.AUTO)
    //    private Long taskId;
    //    @NotBlank(message = "Task name cannot be blank")
    //    @Size(min = 3, max = 10, message = "Task name must be between 3 and 10 characters")
    //    private String taskName;
    //
    //    private LocalTime taskTime;
    //
    //    @FutureOrPresent(message = "Task date must be today or in the future")
    //    private LocalDate taskDate;

}
