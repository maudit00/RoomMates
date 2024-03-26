package it.RoomMates.services;

import it.RoomMates.entities.Users;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder encoder;


    public Page<Users> getAll(Pageable pageable){
        return usersRepository.findAll(pageable);
    }

    public Users saveUser(Users user){
        return usersRepository.save(user);
    }

    public Users getById(int id){
        return usersRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found!"));
    }

    public Users updateUser(int id, Users user){
        Users u = getById(id);
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        u.setPassword(encoder.encode(user.getPassword()));
        return usersRepository.save(u);
    }

    public void delete(int id){
        Users u = getById(id);
        usersRepository.delete(u);
    }

}
