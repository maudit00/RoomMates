package it.RoomMates.requests;

import it.RoomMates.enums.Employment;
import it.RoomMates.enums.Sex;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RoomMateRequest {
    @NotNull(message = "RoomMate can't be saved without an user id to attach" )
    private int idUser;
    @NotNull(message = "Name can't be null")
    private String name;
    @NotNull(message = "Surname can't be null")
    private String surname;
    @NotNull(message = "Age can't be null")
    private int age;
    @NotNull(message = "Sex can't be null")
    private Sex sex;
    @NotNull(message = "Employment can't be null")
    private Employment employment;
}
