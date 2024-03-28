package it.RoomMates.controller;

import it.RoomMates.entities.Tasks;
import it.RoomMates.requests.TaskRequest;
import it.RoomMates.services.TasksService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
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

    @PatchMapping("/{id}")
    public Tasks assignToUser(@PathVariable int id_task, @Param("id_user") int id_user){ return tasksService.assignToUser(id_task,id_user);}
}