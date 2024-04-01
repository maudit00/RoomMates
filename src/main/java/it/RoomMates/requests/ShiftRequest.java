package it.RoomMates.requests;

import it.RoomMates.enums.ShiftType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ShiftRequest {
    @NotBlank( message = "Date can't be null")
    private LocalDate date;

    private int idUser;

    @NotBlank(message = "ShifyType can't be null")
    private ShiftType shiftType;
}
