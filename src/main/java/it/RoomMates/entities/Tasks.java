package it.RoomMates.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id")
    @SequenceGenerator(name = "task_id", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private String description;
    private LocalDate date;
    private boolean done;
}
