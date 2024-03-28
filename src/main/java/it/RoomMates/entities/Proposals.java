package it.RoomMates.entities;

import it.RoomMates.enums.PropStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Proposals {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proposal_id")
    @SequenceGenerator(name = "proposal_id", initialValue = 1, allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private String description;
    @Enumerated(EnumType.STRING)
    private PropStatus status;
}
