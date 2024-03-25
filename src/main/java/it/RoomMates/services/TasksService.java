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
        if (task.getIdUser() == )
        t.setDone(false);
        t.setUser();
    }

}
