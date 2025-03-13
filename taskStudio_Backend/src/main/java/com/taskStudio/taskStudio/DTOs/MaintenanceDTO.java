package com.taskStudio.taskStudio.DTOs;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MId; //This variable is auto-generated for storing Maintenance ID ...

    @Size(min = 1, max = 40, message = "Spare name must be between 3 and 40 characters")
    private String spareName; //This variable is for storing Spare Name...
    @NotNull(message = "Registration cannot be null")
    private String RC; //This holds the registration number of my different vehicles...

    private String issue; //This variable is for storing related or possible issues causing the Spare change ...

    private String brandModel; //This variable is for storing Spare Brand & Model...

    @PositiveOrZero(message = "The number must be zero or positive")
    private int price; //This variable is for storing Spare Price ...

    private Long currentKM; //This is for storing the current running km on the ODO

    private LocalDate replacingDate; //This variable is for storing Spare replacing Date...

    @NotNull(message = "Upcoming check-up KM cannot be null")
    @Min(value = 0, message = "Upcoming check-up KM must be non-negative")
    private Long upcomingCheckUpKM; //This variable is for storing Upcoming Spare Checkup in KMs...

    // @FutureOrPresent(message = "CheckUp date must be today or in the future")
    // private LocalDate upcomingCheckUpDATE; //This variable is for storing Upcoming Spare Checkup in Time...

    private String extraNotes;   // This variable is for storing extra notes if needed ...
}
