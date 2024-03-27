package it.RoomMates.requests;

import it.RoomMates.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsersRequest {

    private int id;

    @NotBlank(message = "Username can't be null")
    private String username;
    @NotBlank(message = "Username can't be null")
    private String password;
    @Email(message = "Insert a valid email")
    private String email;

    private Role role;

}
