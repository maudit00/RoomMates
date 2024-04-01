package it.RoomMates.services;

import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Users;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.BillsRepository;
import it.RoomMates.repositories.UsersRepository;
import it.RoomMates.requests.BillRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@Transactional
public class BillsService {
    @Autowired
    public BillsRepository billsRepository;
    @Autowired
    public UsersService usersService;

    public Bills getById(int id){
        return billsRepository.findById(id).orElseThrow(()-> new NotFoundException("Bill not found"));
    }

    public Page<Bills> getAll(Pageable pageable){
        return billsRepository.findAll(pageable);
    }

    public Bills save(BillRequest billRequest){
        Bills bill = new Bills();
        bill.setDate(LocalDate.now());
        bill.setDeadline(billRequest.getDeadline());
        bill.setAmount(billRequest.getAmount());
        bill.setDescription(billRequest.getDescription());
        return billsRepository.save(bill);
    }
    public Bills update(int id, BillRequest billRequest){
        Bills bill = getById(id);
        bill.setDate(LocalDate.now());
        bill.setDeadline(billRequest.getDeadline());
        bill.setAmount(billRequest.getAmount());
        bill.setDescription(billRequest.getDescription());
        return billsRepository.save(bill);
    }

    public void delete(int id){
        Bills bill = getById(id);
        billsRepository.delete(bill);
    }

    @Transactional
    public void assignUserToBill(int bill_id, int user_id){
        Bills bill = getById(bill_id);
        Users user = usersService.getById(user_id);
        bill.getUsers().add(user);
        billsRepository.save(bill);
    }

}
