package it.RoomMates.controller;

import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Shifts;
import it.RoomMates.requests.ShiftRequest;
import it.RoomMates.services.ShiftsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shifts")
public class ShiftsController {
    @Autowired
    private ShiftsService shiftsService;

    @GetMapping
    public Page<Shifts> getAll(Pageable pageable) {return shiftsService.getAll(pageable);}

    @GetMapping("/{id}")
    public Shifts getById(@PathVariable int id){return shiftsService.getById(id);}
    @GetMapping("/user/{id}")
    public Page<Shifts> getByUserId(@PathVariable int id, Pageable pageable){return shiftsService.getUserShifts(pageable, id);}

    @PostMapping
    public Shifts save(@RequestBody ShiftRequest shiftRequest){return shiftsService.save(shiftRequest);}

    @PutMapping("/{id}")
    public Shifts update(@PathVariable int id, @RequestBody ShiftRequest shiftRequest){ return shiftsService.update(id, shiftRequest);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { shiftsService.delete(id);}
}
