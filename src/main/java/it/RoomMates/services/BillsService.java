package it.RoomMates.services;

import it.RoomMates.repositories.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillsService {
    @Autowired
    private BillsRepository billsRepository;
    @Autowired
    private UsersService usersService;


}
