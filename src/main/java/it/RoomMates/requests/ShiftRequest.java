package it.RoomMates.requests;

import it.RoomMates.enums.ShiftType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ShiftRequest {
    @NotNull( message = "Date can't be null")
    private LocalDate date;

    private int idUser;

    @NotNull(message = "ShifyType can't be null")
    private ShiftType shiftType;
}
