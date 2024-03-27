package it.RoomMates.controller;

import it.RoomMates.entities.Users;
import it.RoomMates.exceptions.BadRequestException;
import it.RoomMates.exceptions.LoginException;
import it.RoomMates.requests.LoginRequest;
import it.RoomMates.requests.UsersRequest;
import it.RoomMates.security.JwtTools;
import it.RoomMates.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private JwtTools jwtTools;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/auth/register")
    public Users register(@RequestBody @Validated UsersRequest usersRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }
        return usersService.saveUser(usersRequest);
    }

    @PostMapping("/auth/login")
    public String login(@RequestBody @Validated LoginRequest loginRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        Users user = usersService.getByUsername(loginRequest.getUsername());

        if (encoder.matches(loginRequest.getPassword(), user.getPassword())){
            return jwtTools.createToken(user);
        } else {
            throw new LoginException("User/Password wrong, try again");
        }
    }
}
