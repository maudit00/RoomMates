package it.RoomMates.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssignRequest {
    @NotBlank(message = "User id can't be blank")
    private int user_id;
}
