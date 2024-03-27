package it.RoomMates.controller;

import it.RoomMates.entities.Users;
import it.RoomMates.security.JwtTools;
import it.RoomMates.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public Users register(@RequestBody @Validated User)
}
