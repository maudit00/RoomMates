package it.RoomMates.responses;

import it.RoomMates.entities.Users;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class LoginResponse {
    private Users user;
    private String token;
    public LoginResponse(Users user, String token){
        this.user=user;
        this.token=token;
    }

    public static ResponseEntity<LoginResponse> login(Users user, String token, HttpStatus status){
        LoginResponse loginResponse = new LoginResponse(user, token);
        return new ResponseEntity<>(loginResponse,status);
    }
}

