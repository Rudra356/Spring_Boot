package com.taskStudio.taskStudio.MaintenanceEntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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

    private Long currentKM;

    private LocalDate replacingDate; //This variable is for storing Spare replacing Date...

    @NotNull(message = "Upcoming check-up KM cannot be null")
    @Min(value = 0, message = "Upcoming check-up KM must be non-negative")
    private Long upcomingCheckUpKM; //This variable is for storing Upcoming Spare Checkup in KMs...

    // @FutureOrPresent(message = "CheckUp date must be today or in the future")
    // private LocalDate upcomingCheckUpDATE; //This variable is for storing Upcoming Spare Checkup in Time...

    private String extraNotes;   // This variable is for storing extra notes if needed ...
}
