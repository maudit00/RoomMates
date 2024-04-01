package it.RoomMates.controller;

import it.RoomMates.entities.Tasks;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.requests.AssignRequest;
import it.RoomMates.requests.TaskRequest;
import it.RoomMates.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

   @PutMapping("/{taskId}/assign/{userId}")
    public ResponseEntity<String> assignUserTotask(@PathVariable int taskId, @PathVariable int userId) {
        try {
            tasksService.assignUserToTask(taskId, userId);
            return ResponseEntity.ok("User assigned to task successfully.");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while assigning user to task.");
        }
}  @PutMapping("/{taskId}/complete/")
    public ResponseEntity<String> completeATask(@PathVariable int taskId) {
        try {
            tasksService.completeTask(taskId);
            return ResponseEntity.ok("User assigned to task successfully.");
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while trying to complete this task.");
        }
    }
}

