package it.RoomMates.services;

import it.RoomMates.repositories.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksService {

    @Autowired
    private BillsRepository billsRepository;


}
