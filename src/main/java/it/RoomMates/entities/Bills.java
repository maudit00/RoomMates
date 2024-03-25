package it.RoomMates.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_id")
    @SequenceGenerator(name = "bill_id", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private String description;
    private double amount;
    private LocalDate date;
}
