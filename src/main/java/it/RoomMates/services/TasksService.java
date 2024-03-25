package it.RoomMates.services;

import it.RoomMates.entities.TaskRequest;
import it.RoomMates.entities.Tasks;
import it.RoomMates.repositories.BillsRepository;
import it.RoomMates.repositories.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
        return tasksRepository.getById(id);
    }
    public Tasks save(TaskRequest task){
        Tasks t = new Tasks();
        t.setDone(false);
        t.setUser(usersService.getById(task.getIdUser()));
        t.setDescription(task.getDescription());
        t.setDate(task.getDate());
        return tasksRepository.save(t);
    }

    public Tasks update(int id, TaskRequest task){
       Tasks t = getById(id);
       t.setDate(task.getDate());
       t.setUser(usersService.getById(task.getIdUser()));
       t.setDescription(task.getDescription());
       t.setDate(task.getDate());
       return tasksRepository.save(t);
    }

    public void delete(int id){
        Tasks t = getById(id);
        tasksRepository.delete(t);
    }

}
