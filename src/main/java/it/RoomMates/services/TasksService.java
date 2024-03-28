package it.RoomMates.services;

import it.RoomMates.entities.Users;
import it.RoomMates.requests.*;
import it.RoomMates.entities.Tasks;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;
    @Autowired
    private UsersService usersService;

    public Page<Tasks> getAll(Pageable pageable){
        return tasksRepository.findAll(pageable);
    }

    public Tasks getById(int id){
        return tasksRepository.findById(id).orElseThrow(()-> new NotFoundException("Tasks not found"));
    }
    public Tasks save(TaskRequest task){
        Tasks t = new Tasks();
        t.setDone(false);
        t.setDescription(task.getDescription());
        t.setCreator(usersService.getById(task.getIdCreator()));
        t.setDate(task.getDate());
        return tasksRepository.save(t);
    }

    public Tasks update(int id, TaskRequest task){
       Tasks t = getById(id);
       t.setDate(task.getDate());
       t.setCreator(usersService.getById(task.getIdCreator()));
       t.setDescription(task.getDescription());
       t.setDate(task.getDate());
       return tasksRepository.save(t);
    }

    public Tasks assignToUser(int id_task,int id_user){
        Tasks t = getById(id_task);
        Users u = usersService.getById(id_user);
        List<Users> currentUsers = t.getUser();
        currentUsers.add(u);
        t.setUser(currentUsers);
        return tasksRepository.save(t);
    }

    public void delete(int id){
        Tasks t = getById(id);
        tasksRepository.delete(t);
    }

}
