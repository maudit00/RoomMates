package it.RoomMates.controller;

import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Users;
import it.RoomMates.requests.AssignRequest;
import it.RoomMates.requests.BillRequest;
import it.RoomMates.requests.TaskRequest;
import it.RoomMates.services.BillsService;
import it.RoomMates.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
//
//    @PatchMapping("/{id_bill}/assign")
//    public Bills assignToUser(@PathVariable int id_bill, @RequestBody AssignRequest assignRequest){ return billsService.assignBill(id_bill, assignRequest.getUser_id());}
    @PostMapping("/{bill_id}/assign/{user_id}")
    public Bills assignUserToBill(@PathVariable int bill_id, @PathVariable int user_id){
        return billsService.assignBill(bill_id, user_id);
    }
}
