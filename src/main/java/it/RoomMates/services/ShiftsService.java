package it.RoomMates.services;

import it.RoomMates.entities.Bills;
import it.RoomMates.entities.Shifts;
import it.RoomMates.entities.Tasks;
import it.RoomMates.entities.Users;
import it.RoomMates.exceptions.NotFoundException;
import it.RoomMates.repositories.ShiftsRepository;
import it.RoomMates.requests.ShiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShiftsService {
    @Autowired
    private ShiftsRepository shiftsRepository;
    @Autowired
    private UsersService usersService;

    public Shifts getById(int id){ return shiftsRepository.findById(id).orElseThrow(() -> new NotFoundException("Shift not found!"));};
    public Page<Shifts> getAll(Pageable pageable){
        return shiftsRepository.findAll(pageable);
    }

    public Shifts save(ShiftRequest shiftRequest){
        Shifts s = new Shifts();
        s.setDate(shiftRequest.getDate());
        s.setUser(usersService.getById(shiftRequest.getIdUser()));
        s.setShiftType(shiftRequest.getShiftType());
        return shiftsRepository.save(s);
    }

    public Shifts update(int id, ShiftRequest shiftRequest){
        Shifts s = getById(id);
        s.setDate(shiftRequest.getDate());
        s.setUser(usersService.getById(shiftRequest.getIdUser()));
        s.setShiftType(shiftRequest.getShiftType());
        return shiftsRepository.save(s);
    }

    public void delete(int id){
        Shifts s = getById(id);
        shiftsRepository.delete(s);
    }
    public Page<Shifts> getUserShifts(Pageable pageable, int user_id){
        Users user = usersService.getById(user_id);
        return shiftsRepository.findByUser(pageable, user);
    }

    public Shifts assignUserToShift(int shift_id, int user_id){
        Shifts shift = getById(shift_id);
        Users user = usersService.getById(user_id);
        shift.setUser(user);
        return shiftsRepository.save(shift);
    }
}
