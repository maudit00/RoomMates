package it.RoomMates.services;

import it.RoomMates.entities.Users;
import it.RoomMates.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public void saveUser(Users user){
        usersRepository.save(user);
    }

    public void updateUser(Users user){
        Users u = usersRepository.findById(user.getId()).get();
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
    }
}
