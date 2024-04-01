package it.RoomMates.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.RoomMates.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id")
    @SequenceGenerator(name = "user_id", initialValue = 1, allocationSize = 1)
    private int id;

    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @ManyToMany(mappedBy = "tasks", fetch = FetchType.EAGER)
    private List<Tasks> tasks;

    @JsonIgnore
    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Bills> bills;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Shifts> shifts;

    @JsonIgnore
    @OneToMany(mappedBy = "creator")
    private List<Tasks> taskCreated;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Proposals> proposals;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}