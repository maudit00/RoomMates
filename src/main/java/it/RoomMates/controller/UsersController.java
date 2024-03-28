package it.RoomMates.controller;

import com.cloudinary.Cloudinary;
import it.RoomMates.entities.Users;
import it.RoomMates.requests.UsersRequest;
import it.RoomMates.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @Autowired
    private Cloudinary cloudinary;

    @GetMapping
    public Page<Users> getAll(Pageable pageable) {return usersService.getAll(pageable);}

    @GetMapping("/{id}")
    public Users getById(@PathVariable int id){return usersService.getById(id);}

    @PostMapping
    public Users save(@RequestBody UsersRequest usersRequest) {return usersService.saveUser(usersRequest);}

    @PutMapping("/{id}")
    public Users update(@PathVariable int id, @RequestBody UsersRequest usersRequest){
        return usersService.updateUser(id, usersRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { usersService.delete(id);}


}
