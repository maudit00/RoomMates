package it.RoomMates.controller;

import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Bills;
import it.RoomMates.requests.AssignRequest;
import it.RoomMates.requests.BillRequest;
import it.RoomMates.requests.TaskRequest;
import it.RoomMates.services.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

public class BillsController {
    @Autowired
    private BillsService billsService;
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
    @PatchMapping("/{id_bill}/assign")
    public Bills assignToUser(@PathVariable int id_bill, @RequestBody AssignRequest assignRequest){ return billsService.assignTask(id_task, assignRequest.getUser_id());}


}
