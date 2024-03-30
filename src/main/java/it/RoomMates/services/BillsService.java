package it.RoomMates.services;

import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Users;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.BillsRepository;
import it.RoomMates.requests.BillRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
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

    public Bills assignBill(int id_bill, int id_user){
        Bills bill = getById(id_bill);
        Users user = usersService.getById(id_user);
        bill.getUser().add(user);
        return billsRepository.save(bill);
    }
}
