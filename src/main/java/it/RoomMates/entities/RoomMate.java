package it.RoomMates.entities;

import it.RoomMates.enums.Employment;
import it.RoomMates.enums.Sex;
import jakarta.persistence.*;
import lombok.Data;
import org.apache.catalina.User;

@Data
@Entity
public class RoomMate {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomate_id")
    @SequenceGenerator(name ="roomate_id", initialValue = 1, allocationSize = 1)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Enumerated(EnumType.STRING)
    private Employment employment;

    private String name;
    private String surname;
    private int age;
    private Sex sex;

}
