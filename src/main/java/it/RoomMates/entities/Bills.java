package it.RoomMates.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_id")
    @SequenceGenerator(name = "bill_id", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToMany(mappedBy = "bills")
    private List<Users> user;

    private String description;
    private double amount;
    private LocalDate date;
    private LocalDate deadline;
}
