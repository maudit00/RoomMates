package it.RoomMates.services;

import it.RoomMates.RoomMatesApplication;
import it.RoomMates.entities.RoomMate;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.RoomMateRepository;
import it.RoomMates.requests.RoomMateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoomMateService {
    @Autowired
    private RoomMateRepository roomMateRepository;
    @Autowired
    private UsersService usersService;

    public Page<RoomMate> getAll(Pageable pageable){
        return roomMateRepository.findAll(pageable);
    }


    public RoomMate getById(int id){return roomMateRepository.findById(id).orElseThrow(()-> new NotFoundException("RoomMate not found!"));};

    public RoomMate save(RoomMateRequest roomMateRequest){
        RoomMate r = new RoomMate();
        r.setUser(usersService.getById(roomMateRequest.getIdUser()));
        r.setAge(roomMateRequest.getAge());
        r.setSex(roomMateRequest.getSex());
        r.setName(roomMateRequest.getName());
        r.setSurname(roomMateRequest.getSurname());
        r.setEmployment(roomMateRequest.getEmployment());
        return roomMateRepository.save(r);
    }

    public RoomMate update(int id,RoomMateRequest roomMateRequest){
        RoomMate r = getById(id);
        r.setUser(usersService.getById(roomMateRequest.getIdUser()));
        r.setAge(roomMateRequest.getAge());
        r.setSex(roomMateRequest.getSex());
        r.setName(roomMateRequest.getName());
        r.setSurname(roomMateRequest.getSurname());
        r.setEmployment(roomMateRequest.getEmployment());
        return roomMateRepository.save(r);
    }

    public void delete(int id){
        RoomMate r = getById(id);
        roomMateRepository.delete(r);
    }

}
