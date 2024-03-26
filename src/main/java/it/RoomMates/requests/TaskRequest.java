package it.RoomMates.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskRequest {
    @NotNull(message = "Task's description can't be null" )
    private String description;
    @NotNull(message = "Date can't be null" )
    private LocalDate date;
    private int idUser;
}
