package it.RoomMates.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BillRequest {
    @NotBlank(message = "Description Can't be null!")
    private String description;
    @NotBlank(message = "The bill's total can't be null!")
    private Double amount;
    @NotBlank(message = "Bill's deadline can't be null")
    private LocalDate deadline;
}
