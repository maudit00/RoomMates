package it.RoomMates.controller;

import it.RoomMates.entities.RoomMate;
import it.RoomMates.requests.RoomMateRequest;
import it.RoomMates.services.RoomMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roommates")
public class RoomMateController {
    @Autowired
    private RoomMateService roomMateService;

    @GetMapping
    public Page<RoomMate> getAll(Pageable pageable) {return roomMateService.getAll(pageable);}

    @GetMapping("/{id}")
    public RoomMate getById(@PathVariable int id){return roomMateService.getById(id);}

    @PostMapping
    public RoomMate save(@RequestBody RoomMateRequest roomMateRequest){return roomMateService.save(roomMateRequest);}

    @PutMapping("/{id}")
    public RoomMate update(@PathVariable int id, @RequestBody RoomMateRequest roomMateRequest){ return roomMateService.update(id, roomMateRequest);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { roomMateService.delete(id);}
}
