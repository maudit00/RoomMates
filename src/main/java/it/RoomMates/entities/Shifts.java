package it.RoomMates.entities;

import it.RoomMates.enums.ShiftType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Shifts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shift_id")
    @SequenceGenerator(name = "shift_id", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private ShiftType shiftType;
}
