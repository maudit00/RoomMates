package it.RoomMates.entities;

import it.RoomMates.enums.ShiftType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Shifts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_utenti")
    @SequenceGenerator(name = "id_utenti", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private LocalDate date;
    @Enumerated
    private ShiftType shiftType;
}
