package it.RoomMates.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id")
    @SequenceGenerator(name = "task_id", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tasks_user",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private List<Users> users;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users creator;

    private String description;
    private LocalDate date;
    private boolean done;
}
