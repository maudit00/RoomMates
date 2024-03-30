package it.RoomMates.controller;

import it.RoomMates.entities.Tasks;
import it.RoomMates.requests.AssignRequest;
import it.RoomMates.requests.TaskRequest;
import it.RoomMates.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    private TasksService tasksService;

    @GetMapping
    public Page<Tasks> getAll(Pageable pageable) {return tasksService.getAll(pageable);}

    @GetMapping("/{id}")
    public Tasks getById(@PathVariable int id){return tasksService.getById(id);}

    @PostMapping
    public Tasks save(@RequestBody TaskRequest taskRequest){return tasksService.save(taskRequest);}

    @PutMapping("/{id}")
    public Tasks update(@PathVariable int id, @RequestBody TaskRequest taskRequest){ return tasksService.update(id, taskRequest);}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) { tasksService.delete(id);}
    @PatchMapping("/{id_task}/assign")
    public Tasks assignToUser(@PathVariable int id_task, @RequestBody AssignRequest assignRequest){ return tasksService.assignTask(id_task, assignRequest.getUser_id());}

}
