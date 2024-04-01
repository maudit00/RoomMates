package it.RoomMates.controller;

import it.RoomMates.entities.Bills;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.requests.BillRequest;
import it.RoomMates.services.BillsService;
import it.RoomMates.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bills")
public class BillsController {
    @Autowired
    private BillsService billsService;
    @Autowired
    private UsersService usersService;
    @GetMapping
    public Page<Bills> getAll(Pageable pageable){return billsService.getAll(pageable);}
    @GetMapping("/{id}")
    public Bills getById(@PathVariable int id){return billsService.getById(id);}

    @PostMapping
    public Bills save(@RequestBody BillRequest billRequest){return billsService.save(billRequest);}

    @PutMapping("/{id}")
    public Bills update(@PathVariable int id, @RequestBody BillRequest billRequest){ return billsService.update(id, billRequest);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { billsService.delete(id);}
    @PutMapping("/{billId}/assign/{userId}")
    public ResponseEntity<String> assignUserToBill(@PathVariable int billId, @PathVariable int userId) {
        try {
            billsService.assignUserToBill(billId, userId);
            return ResponseEntity.ok("User assigned to bill successfully.");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while assigning user to bill.");
        }
    }
}
