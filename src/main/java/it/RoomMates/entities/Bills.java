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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "bill_user",
            joinColumns = @JoinColumn(name = "bill_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<Users> users; // Change mappedBy to "users

    private String description;
    private double amount;
    private LocalDate date;
    private LocalDate deadline;
}
