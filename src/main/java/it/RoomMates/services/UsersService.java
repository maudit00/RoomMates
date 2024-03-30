package it.RoomMates.services;

import it.RoomMates.entities.Tasks;
import it.RoomMates.entities.Users;
import it.RoomMates.enums.Role;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.UsersRepository;
import it.RoomMates.requests.UsersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.config.Task;
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

    public Users saveUser(UsersRequest user){
        Users u = new Users();
        u.setRole(Role.USER);
        u.setPassword(encoder.encode(user.getPassword()));
        u.setUsername(user.getUsername());
        u.setEmail(user.getEmail());
        return usersRepository.save(u);
    }

    public Users getById(int id){
        return usersRepository.findById(id).orElseThrow(()-> new NotFoundException("User not found!"));
    }

    public Users getByUsername(String username){
        return usersRepository.findByUsername(username).orElseThrow(()-> new NotFoundException("User not Found!"));
    }

    public Users updateUser(int id, UsersRequest user){
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

    private void sendMail(String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("User Registration successfull");
        message.setText("Welcome to RoomMates, we're glad you joined us. Start discover our web app and stop arguing with ur roommates");
    }

}
